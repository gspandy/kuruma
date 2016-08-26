package com.github.yingzhuo.kuruma.user.dao

import com.github.yingzhuo.kuruma.common.entity.AccessToken
import com.github.yingzhuo.kuruma.common.entity.User

interface UserDao {

    fun findUserById(id: String): User?

    fun saveUser(user: User): User

    fun testPassword(name: String, password: String): String?

    fun findAccessTokenByUserId(userId: String): AccessToken?

    fun updateAccessToken(userId: String, expiredTime: Long)

    fun saveAccessToken(accessToken: AccessToken)
}