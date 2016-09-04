package com.github.yingzhuo.kuruma.car.controller

import com.github.yingzhuo.kuruma.car.controller.request.CarRequest
import com.github.yingzhuo.kuruma.car.service.CarService
import com.github.yingzhuo.kuruma.common.Json
import com.github.yingzhuo.kuruma.common.exception.BadRequestException
import com.github.yingzhuo.kuruma.common.validate.Create
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

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
    open fun findCarsByUserId(@PathVariable("userId") userId: String): ResponseEntity<Json> {
        val cars = carService.findCarsByUserId(userId)
        return Json.create()
                .put("cars" to cars)
                .asResponseEntity()
    }

    @PostMapping
    open fun saveCar(
            @Validated(Create::class) carRequest: CarRequest,
            bindingResult: BindingResult): ResponseEntity<Json> {

        if (bindingResult.hasErrors()) {
            throw BadRequestException(bindingResult.allErrors)
        }

        carService.saveCar(carRequest)
        return Json.create(HttpStatus.CREATED)
                .asResponseEntity()
    }

    // TODO:
    @PutMapping("{carId}", params = arrayOf("name"))
    fun updateCarName(
            @PathVariable("carId") carId: String,
            @RequestParam("name") name: String): ResponseEntity<Json> {

        carService.updateCarName(carId, name)
        return Json.create(HttpStatus.CREATED)
                .asResponseEntity()
    }


}
