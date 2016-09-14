package com.github.yingzhuo.kuruma.car.dao

import com.github.yingzhuo.kuruma.common.entity.Car

interface CarDao {

    fun findCarById(carId: String): Car?

    fun findCarsByUserId(userId: String): List<Car>

}
