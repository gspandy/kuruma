package com.github.yingzhuo.kuruma.user.dao.impl

import com.github.yingzhuo.kuruma.common.entity.User
import com.github.yingzhuo.kuruma.user.dao.UserDao
import com.github.yingzhuo.kuruma.user.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository("userDao")
open class UserDaoImpl @Autowired constructor(val userMapper: UserMapper) : UserDao {

    override fun findUserById(id: String): User? = userMapper.findById(id)

}
