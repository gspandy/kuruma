package com.github.yingzhuo.kuruma.user.controller

import com.github.yingzhuo.kuruma.common.Gender
import com.github.yingzhuo.kuruma.common.Json
import com.github.yingzhuo.kuruma.common.exception.BadRequestException
import com.github.yingzhuo.kuruma.common.validate.Create
import com.github.yingzhuo.kuruma.user.controller.request.UserRequest
import com.github.yingzhuo.kuruma.user.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
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
    open fun regiesterUser(@Validated(Create::class) request: UserRequest, bindingResult: BindingResult): ResponseEntity<Json> {

        if (bindingResult.hasErrors()) {
            throw BadRequestException(bindingResult.allErrors)
        }

        LOGGER.debug("request: {}", request)
        val user = userService.regiesterUser(request)
        return Json.create(HttpStatus.CREATED)
                .put("user" to user)
                .asResponseEntity()
    }

    @PutMapping("{userId}/gender/{gender}")
    open fun updateGender(@PathVariable("userId") userId: String, @PathVariable("gender") gender: Gender): ResponseEntity<Json> {
        userService.updateUserGender(userId, gender)
        return Json.create(HttpStatus.CREATED)
                .asResponseEntity()
    }

    @PutMapping("{userId}/password/{newPassword}")
    open fun updatePassword(
            @PathVariable("userId") userId: String,
            @PathVariable("newPassword") newPassword: String,
            @MatrixVariable(name = "o", pathVar = "newPassword", required = true) oldPassword: String): ResponseEntity<Json> {

        LOGGER.debug("old pwd: {}", oldPassword)
        LOGGER.debug("new pwd: {}", newPassword)

        userService.updateUserPassword(userId, newPassword, oldPassword)
        return Json.create(HttpStatus.CREATED)
                .asResponseEntity()
    }

}
