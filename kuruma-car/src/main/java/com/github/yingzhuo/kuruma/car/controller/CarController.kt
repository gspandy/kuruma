package com.github.yingzhuo.kuruma.car.controller

import com.github.yingzhuo.kuruma.car.service.CarService
import com.github.yingzhuo.kuruma.common.Json
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("cars")
open class CarController @Autowired constructor(val carService: CarService) {

    @GetMapping("{carId}")
    open fun findCarById(@PathVariable("carId") carId: String): ResponseEntity<Json> {
        val car = carService.findCarById(carId)
        return Json.create()
                .put("car" to car)
                .asResponseEntity()
    }

    @GetMapping("user/{userId}")
    open fun findCarsByUserId(@PathVariable("userId") userId: String): Any {
        val cars = carService.findCarsByUserId(userId)
        return cars
    }

}
