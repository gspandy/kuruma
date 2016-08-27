package com.github.yingzhuo.kuruma.user.service.impl

import com.github.yingzhuo.kuruma.common.entity.AccessToken
import com.github.yingzhuo.kuruma.common.entity.User
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

        if (accessToken == null) {
            accessToken = AccessToken(userId, uuid(), exp)
            userDao.saveAccessToken(accessToken)
        } else {
            userDao.updateAccessToken(userId, exp)
        }

        accessToken.expiredTime = exp
        return accessToken
    }
}
