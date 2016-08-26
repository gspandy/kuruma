package com.github.yingzhuo.kuruma.user.dao.impl

import com.github.yingzhuo.kuruma.common.entity.User
import com.github.yingzhuo.kuruma.common.uuid
import com.github.yingzhuo.kuruma.user.dao.UserDao
import com.github.yingzhuo.kuruma.user.mapper.UserMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository("userDao")
open class UserDaoImpl @Autowired constructor(val userMapper: UserMapper) : UserDao {

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

}
