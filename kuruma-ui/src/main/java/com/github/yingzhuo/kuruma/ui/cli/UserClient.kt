package com.github.yingzhuo.kuruma.ui.cli

import com.github.yingzhuo.kuruma.common.entity.User
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("KURUMA-USER")
interface UserClient {

    @RequestMapping("users/{userId}", method = arrayOf(RequestMethod.GET))
    fun findUserById(@PathVariable("userId") userId: String): User

}
