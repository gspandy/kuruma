package com.github.yingzhuo.kuruma.user.controller

import com.github.yingzhuo.kuruma.common.Json
import com.github.yingzhuo.kuruma.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("tokens")
open class TokenController constructor(val userService: UserService) {


    @PostMapping("user/{name}/password/{password}")
    open fun createToken(
            @PathVariable("name") userName: String,
            @PathVariable("password") password: String): ResponseEntity<Json> {

        val token = userService.generateAccessToken(userName, password)

        return Json.create(HttpStatus.CREATED)
                .put("token" to token.token!!)
                .asResponseEntity()
    }

}