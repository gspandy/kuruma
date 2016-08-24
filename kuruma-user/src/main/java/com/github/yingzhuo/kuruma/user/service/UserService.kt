package com.github.yingzhuo.kuruma.user.service

import com.github.yingzhuo.kuruma.common.entity.User
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

interface UserService {

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    fun findUserById(userId: String): User

}
