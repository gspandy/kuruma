package com.github.yingzhuo.kuruma.car.service

import com.github.yingzhuo.kuruma.car.controller.request.CarRequest
import com.github.yingzhuo.kuruma.common.entity.Car
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

interface CarService {

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    fun findCarById(carId: String): Car

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    fun findCarsByUserId(userId: String): List<Car>

    @Transactional(propagation = Propagation.REQUIRED)
    fun saveCar(carRequest: CarRequest): Car

}
