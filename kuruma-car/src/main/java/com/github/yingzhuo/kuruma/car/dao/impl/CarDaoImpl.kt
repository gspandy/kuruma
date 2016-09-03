package com.github.yingzhuo.kuruma.car.dao.impl

import com.github.yingzhuo.kuruma.car.dao.CarDao
import com.github.yingzhuo.kuruma.car.mapper.CarMapper
import com.github.yingzhuo.kuruma.common.entity.Car
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository("carDao")
open class CarDaoImpl @Autowired constructor(val carMapper: CarMapper) : CarDao {

    override fun existsCarById(carId: String): Boolean = carMapper.existsById(carId)

    override fun findCarById(carId: String): Car? = carMapper.findById(carId)

    override fun findCarsByUserId(userId: String): List<Car> = carMapper.findByUserId(userId)

}
