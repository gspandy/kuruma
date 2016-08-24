package com.github.yingzhuo.kuruma.user.controller

import com.github.yingzhuo.kuruma.common.Json
import com.github.yingzhuo.kuruma.user.controller.request.UserRequest
import com.github.yingzhuo.kuruma.user.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
open class UserController @Autowired constructor(val userService: UserService) {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(UserController::class.java)
    }

    @GetMapping("{userId}")
    open fun findOne(@PathVariable("userId") userId: String): ResponseEntity<Json> {
        LOGGER.debug("userId: {}", userId)

        val user = userService.findUserById(userId)
        return Json.create()
                .put("user" to user)
                .asResponseEntity()
    }

    @PostMapping
    open fun regiesterUser(request: UserRequest): ResponseEntity<Json> {
        LOGGER.debug("request: {}", request)
        val user = userService.regiesterUser(request)
        return Json.create(HttpStatus.CREATED)
                .put("user" to user)
                .asResponseEntity()
    }

}
