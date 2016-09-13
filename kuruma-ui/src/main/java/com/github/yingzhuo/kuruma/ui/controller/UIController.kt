package com.github.yingzhuo.kuruma.ui.controller

import com.github.yingzhuo.kuruma.ui.Services
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
open class UIController @Autowired constructor(val restTemplate: RestTemplate) {

    companion object {
        private val LOGGER: Logger = LoggerFactory.getLogger(UIController::class.java)
    }

    @GetMapping("ui")
    open fun ui(): Any {
        val user = restTemplate.getForEntity("http://${Services.CAR}/users/9e21b083aff2ea3acdd9cf9df5a91141", String::class.java).body
        LOGGER.trace("user")
        return user
    }

}
