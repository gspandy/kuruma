package com.github.yingzhuo.kuruma.user.dao

import com.github.yingzhuo.kuruma.common.Gender
import com.github.yingzhuo.kuruma.common.entity.AccessToken
import com.github.yingzhuo.kuruma.common.entity.User

interface UserDao {

    fun findUserById(id: String): User?

    fun saveUser(user: User): User

    fun updateGender(userId: String, gender: Gender): Unit

    fun updatePassword(userId: String, password: String): Unit

    fun testPassword(name: String, password: String): String?

    fun testPasswordByUserId(userId: String, password: String): Boolean

    fun findAccessTokenByUserId(userId: String): AccessToken?

    fun findAccessTokenByToken(token: String): AccessToken?

    fun updateAccessToken(userId: String, token: String, expiredTime: Long): Unit

    fun saveAccessToken(accessToken: AccessToken): Unit

}
