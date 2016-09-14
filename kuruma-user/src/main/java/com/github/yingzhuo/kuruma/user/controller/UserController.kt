package com.github.yingzhuo.kuruma.user.controller

import com.github.yingzhuo.kuruma.user.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
open class UserController @Autowired constructor(val userService: UserService) {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(UserController::class.java)
    }

    @GetMapping("{userId}")
    open fun findOne(@PathVariable("userId") userId: String): Any {
        LOGGER.debug("userId: {}", userId)

        val user = userService.findUserById(userId)
        return user
    }

}
