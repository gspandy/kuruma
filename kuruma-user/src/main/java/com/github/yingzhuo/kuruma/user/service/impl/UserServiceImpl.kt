package com.github.yingzhuo.kuruma.user.service.impl

import com.github.yingzhuo.kuruma.common.Gender
import com.github.yingzhuo.kuruma.common.entity.AccessToken
import com.github.yingzhuo.kuruma.common.entity.User
import com.github.yingzhuo.kuruma.common.exception.ForbiddenException
import com.github.yingzhuo.kuruma.common.exception.ResourceNotFoundException
import com.github.yingzhuo.kuruma.common.uuid
import com.github.yingzhuo.kuruma.user.controller.request.UserRequest
import com.github.yingzhuo.kuruma.user.dao.UserDao
import com.github.yingzhuo.kuruma.user.password.PasswordHasher
import com.github.yingzhuo.kuruma.user.service.UserService
import org.apache.commons.beanutils.PropertyUtils
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.annotation.Cacheable
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.stereotype.Service
import java.util.*
import javax.annotation.PostConstruct

@Service
@RefreshScope
open class UserServiceImpl @Autowired constructor(
        val userDao: UserDao,
        val passwordHasher: PasswordHasher) : UserService {

    @Value("\${tokenTTL:7200}")
    var tokenTTL: Long = -1

    companion object {
        private val LOGGER = LoggerFactory.getLogger(UserServiceImpl::class.java)
    }

    @PostConstruct
    fun init() {
        LOGGER.debug("tokenTTL: {}", tokenTTL)
    }

    @Cacheable("userCache", keyGenerator = "keyGen")
    override fun findUserById(userId: String): User {
        return userDao.findUserById(userId) ?: throw ResourceNotFoundException()
    }

    override fun regiesterUser(request: UserRequest): User {
        request.password = passwordHasher.hash(request.password!!)

        val user = User()
        user.id = uuid()
        user.regiesterDate = Date()
        PropertyUtils.copyProperties(user, request)
        return userDao.saveUser(user)
    }

    override fun generateAccessToken(name: String, password: String): AccessToken {
        val hashedPassword = passwordHasher.hash(password)

        val userId: String = userDao.testPassword(name, hashedPassword) ?: throw ResourceNotFoundException()

        var accessToken: AccessToken? = userDao.findAccessTokenByUserId(userId)
        val exp = Date().time + tokenTTL

        val newToken = uuid()
        if (accessToken == null) {
            accessToken = AccessToken(userId, newToken, exp)
            userDao.saveAccessToken(accessToken)
        } else {
            userDao.updateAccessToken(userId, newToken, exp)
        }

        accessToken.expiredTime = exp
        accessToken.token = newToken
        return accessToken
    }

    override fun updateUserGender(userId: String, gender: Gender) {
        if (userDao.notExistsUserById(userId)) {
            throw ResourceNotFoundException()
        }
        userDao.updateGender(userId, gender)
    }

    override fun updateUserPassword(userId: String, newPassword: String, oldPassword: String) {
        if (userDao.notExistsUserById(userId)) {
            throw ResourceNotFoundException()
        }

        if (!userDao.testPasswordByUserId(userId, passwordHasher.hash(oldPassword))) {
            LOGGER.debug("旧密码错误")
            throw ForbiddenException()
        }

        LOGGER.debug("旧密码正确")
        val hashedPassword = passwordHasher.hash(newPassword)
        userDao.updatePassword(userId, hashedPassword)
    }

}
