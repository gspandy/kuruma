package com.github.yingzhuo.kuruma.user.dao.impl

import com.github.yingzhuo.kuruma.common.entity.AccessToken
import com.github.yingzhuo.kuruma.common.entity.User
import com.github.yingzhuo.kuruma.user.dao.UserDao
import com.github.yingzhuo.kuruma.user.mapper.AccessTokenMapper
import com.github.yingzhuo.kuruma.user.mapper.UserMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository("userDao")
open class UserDaoImpl @Autowired constructor(
        val userMapper: UserMapper,
        val accessTokenMapper: AccessTokenMapper
) : UserDao {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(UserDaoImpl::class.java)
    }

    override fun findUserById(id: String): User? {
        LOGGER.trace("userId: {}", id)
        return userMapper.findById(id)
    }

    override fun saveUser(user: User): User {
        userMapper.save(user)
        return user
    }

    override fun testPassword(name: String, password: String): String? {

        if (name.isNullOrBlank() || password.isNullOrBlank()) {
            return null
        }

        return userMapper.testPassword(name, password)
    }

    override fun findAccessTokenByUserId(userId: String): AccessToken? {
        return accessTokenMapper.findByUserId(userId)
    }

    override fun updateAccessToken(userId: String, expiredTime: Long) {
        accessTokenMapper.updateExpiredTime(userId, expiredTime)
    }

    override fun saveAccessToken(accessToken: AccessToken) {
        accessTokenMapper.saveAccessToken(accessToken)
    }

}
