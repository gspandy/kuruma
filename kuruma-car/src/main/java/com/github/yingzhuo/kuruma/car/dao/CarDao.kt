package com.github.yingzhuo.kuruma.car.dao

import com.github.yingzhuo.kuruma.common.entity.Car

interface CarDao {

    fun existsCarById(carId: String): Boolean

    fun findCarById(carId: String): Car?

}
