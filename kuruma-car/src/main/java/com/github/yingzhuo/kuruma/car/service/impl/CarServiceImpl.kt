package com.github.yingzhuo.kuruma.car.service.impl

import com.github.yingzhuo.kuruma.car.dao.CarDao
import com.github.yingzhuo.kuruma.car.service.CarService
import com.github.yingzhuo.kuruma.common.entity.Car
import com.github.yingzhuo.kuruma.common.exception.ResourceNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("carService")
open class CarServiceImpl @Autowired constructor(val carDao: CarDao) : CarService {

    override fun findCarById(carId: String): Car = carDao.findCarById(carId) ?: throw ResourceNotFoundException()

    override fun findCarsByUserId(userId: String): List<Car> {
        val cars = carDao.findCarsByUserId(userId)

        if (cars.isEmpty()) {
            throw ResourceNotFoundException()
        }

        return cars
    }

}
