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

    override fun saveCar(car: Car) {
        carMapper.saveCar(car)
    }

    override fun updateCarName(id: String, name: String) {
        carMapper.updateCarName(id, name)
    }

    override fun updateCarDescription(id: String, description: String) {
        carMapper.updateCarDescription(id, description)
    }

    override fun updateCarLicence(id: String, licence: String) {
        carMapper.updateCarLicence(id, licence)
    }

}
