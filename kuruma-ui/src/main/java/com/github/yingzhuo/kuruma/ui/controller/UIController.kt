package com.github.yingzhuo.kuruma.ui.controller

import com.github.yingzhuo.kuruma.common.entity.Bill
import com.github.yingzhuo.kuruma.common.entity.Car
import com.github.yingzhuo.kuruma.common.entity.User
import com.github.yingzhuo.kuruma.ui.Services
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
open class UIController @Autowired constructor(val restTemplate: RestTemplate) {

    companion object {
        private val USER_ID = "9e21b083aff2ea3acdd9cf9df5a91141"
    }

    @GetMapping("ui")
    open fun ui(): Any {
        val user: User = restTemplate.getForEntity("http://${Services.USER}/users/$USER_ID", User::class.java).body
        val cars: Array<Car> = restTemplate.getForEntity("http://${Services.CAR}/cars/user/$USER_ID", Array<Car>::class.java).body
        val bills: Array<Bill> = restTemplate.getForEntity("http://${Services.BILL}/bills/user/$USER_ID", Array<Bill>::class.java).body

        return object : Any() {
            val user = user
            val cars = cars
            val bills = bills
        }
    }

}
