package com.github.yingzhuo.kuruma.car.dao

import com.github.yingzhuo.kuruma.common.entity.Car

interface CarDao {

    fun existsCarById(carId: String): Boolean

    fun findCarById(carId: String): Car?

    fun findCarsByUserId(userId: String): List<Car>

    fun saveCar(car: Car)

    fun updateCarName(id: String, name: String): Unit

    fun updateCarDescription(id: String, description: String): Unit

    fun updateCarLicence(id: String, licence: String): Unit

}
