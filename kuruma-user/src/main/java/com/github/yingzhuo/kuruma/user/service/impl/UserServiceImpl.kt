package com.github.yingzhuo.kuruma.user.service.impl

import com.github.yingzhuo.kuruma.common.entity.User
import com.github.yingzhuo.kuruma.common.exception.ResourceNotFoundException
import com.github.yingzhuo.kuruma.user.controller.request.UserRequest
import com.github.yingzhuo.kuruma.user.dao.UserDao
import com.github.yingzhuo.kuruma.user.password.PasswordHasher
import com.github.yingzhuo.kuruma.user.service.UserService
import org.apache.commons.beanutils.PropertyUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
open class UserServiceImpl @Autowired constructor(
        val userDao: UserDao,
        val passwordHasher: PasswordHasher): UserService {

    override fun findUserById(userId: String): User {
        return userDao.findUserById(userId) ?: throw ResourceNotFoundException()
    }

    override fun regiesterUser(request: UserRequest): User {
        request.password = passwordHasher.hash(request.password!!)

        val user = User()
        PropertyUtils.copyProperties(user, request)
        return userDao.saveUser(user)
    }

}
