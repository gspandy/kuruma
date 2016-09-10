package com.github.yingzhuo.kuruma.user.service.impl

import com.github.yingzhuo.kuruma.common.entity.User
import com.github.yingzhuo.kuruma.common.exception.ResourceNotFoundException
import com.github.yingzhuo.kuruma.user.dao.UserDao
import com.github.yingzhuo.kuruma.user.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.annotation.Cacheable
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
@RefreshScope
open class UserServiceImpl @Autowired constructor(val userDao: UserDao) : UserService {

    @Value("\${tokenTTL:7200}")
    var tokenTTL: Long = -1

    companion object {
        private val LOGGER = LoggerFactory.getLogger(UserServiceImpl::class.java)
    }

    @PostConstruct
    fun init() {
        LOGGER.debug("tokenTTL: {}", tokenTTL)
    }

    @Cacheable("userCache", keyGenerator = "keyGen")
    override fun findUserById(userId: String): User {
        return userDao.findUserById(userId) ?: throw ResourceNotFoundException()
    }

}
