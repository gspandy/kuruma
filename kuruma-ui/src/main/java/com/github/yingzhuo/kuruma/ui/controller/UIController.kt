package com.github.yingzhuo.kuruma.ui.controller

import com.github.yingzhuo.kuruma.common.entity.Bill
import com.github.yingzhuo.kuruma.common.entity.Car
import com.github.yingzhuo.kuruma.common.entity.User
import com.github.yingzhuo.kuruma.ui.cli.BillClient
import com.github.yingzhuo.kuruma.ui.cli.CarClient
import com.github.yingzhuo.kuruma.ui.cli.UserClient
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
open class UIController @Autowired constructor(val userClient: UserClient, val carClient: CarClient, val billClient: BillClient) {

    companion object {
        private val USER_ID = "9e21b083aff2ea3acdd9cf9df5a91141"
    }

    @GetMapping("ui")
    open fun ui(): Any {
        val user: User = userClient.findUserById(USER_ID)
        val cars: Array<Car> = carClient.findCarsByUserId(USER_ID)
        val bills: Array<Bill> = billClient.findBillsByUserId(USER_ID)

        return object : Any() {
            val user = user
            val cars = cars
            val bills = bills
        }
    }

}
