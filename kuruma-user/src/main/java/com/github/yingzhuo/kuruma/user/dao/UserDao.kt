package com.github.yingzhuo.kuruma.user.dao

import com.github.yingzhuo.kuruma.common.entity.User

interface UserDao {

    fun findUserById(id: String): User?

    fun saveUser(user: User): User

}