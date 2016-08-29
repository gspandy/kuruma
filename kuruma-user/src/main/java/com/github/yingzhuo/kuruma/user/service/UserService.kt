package com.github.yingzhuo.kuruma.user.service

import com.github.yingzhuo.kuruma.common.Gender
import com.github.yingzhuo.kuruma.common.entity.AccessToken
import com.github.yingzhuo.kuruma.common.entity.User
import com.github.yingzhuo.kuruma.user.controller.request.UserRequest
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

interface UserService {

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    fun findUserById(userId: String): User

    @Transactional(propagation = Propagation.REQUIRED)
    fun regiesterUser(request: UserRequest): User

    @Transactional(propagation = Propagation.REQUIRED)
    fun generateAccessToken(name: String, password: String): AccessToken

    @Transactional(propagation = Propagation.REQUIRED)
    fun updateUserGender(userId: String, gender: Gender)

    @Transactional(propagation = Propagation.REQUIRED)
    fun updateUserPassword(userId: String, newPassword: String, oldPassword: String)

}
