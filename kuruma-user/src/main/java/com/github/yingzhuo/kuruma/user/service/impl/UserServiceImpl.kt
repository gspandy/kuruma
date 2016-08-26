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
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import java.util.concurrent.TimeUnit

@Service
open class UserServiceImpl @Autowired constructor(
        val userDao: UserDao,
        val passwordHasher: PasswordHasher) : UserService {

    companion object {
        private val EXP = TimeUnit.HOURS.toMillis(4)
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

        val userId: String = userDao.testPassword(name, password) ?: throw ResourceNotFoundException()

        var accessToken: AccessToken? = userDao.findAccessTokenByUserId(userId)
        val exp = Date().time + EXP

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
