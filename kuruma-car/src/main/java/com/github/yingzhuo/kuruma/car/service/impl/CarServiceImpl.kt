package com.github.yingzhuo.kuruma.car.service.impl

import com.github.yingzhuo.kuruma.car.controller.request.CarRequest
import com.github.yingzhuo.kuruma.car.dao.CarDao
import com.github.yingzhuo.kuruma.car.service.CarService
import com.github.yingzhuo.kuruma.common.entity.Car
import com.github.yingzhuo.kuruma.common.exception.ResourceNotFoundException
import com.github.yingzhuo.kuruma.common.uuid
import org.apache.commons.beanutils.PropertyUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service("carService")
open class CarServiceImpl @Autowired constructor(val carDao: CarDao) : CarService {

    override fun findCarById(carId: String): Car = carDao.findCarById(carId) ?: throw ResourceNotFoundException()

    override fun findCarsByUserId(userId: String): List<Car> {
        if (userId.isBlank()) {
            return listOf()
        }

        val cars = carDao.findCarsByUserId(userId)

        if (cars.isEmpty()) {
            throw ResourceNotFoundException()
        }

        return cars
    }

    override fun saveCar(carRequest: CarRequest): Car {
        val car = Car()
        car.id = uuid()
        car.createdDate = Date()
        PropertyUtils.copyProperties(car, carRequest)
        carDao.saveCar(car)
        return car
    }
}
