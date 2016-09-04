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

    @Transactional(propagation = Propagation.REQUIRED)
    fun updateCarName(id: String, name: String): Unit

    @Transactional(propagation = Propagation.REQUIRED)
    fun updateCarDescription(id: String, description: String): Unit

    @Transactional(propagation = Propagation.REQUIRED)
    fun updateCarLicence(id: String, licence: String): Unit

}
