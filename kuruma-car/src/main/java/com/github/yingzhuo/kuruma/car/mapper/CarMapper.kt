package com.github.yingzhuo.kuruma.car.mapper

import com.github.yingzhuo.kuruma.common.entity.Car
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Select

@Mapper
interface CarMapper {

    @Select("SELECT COUNT(ID) FROM T_CAR WHERE ID = #{id}")
    fun existsById(@Param("id") carId: String): Boolean

    @ResultMap("car.base")
    @Select("SELECT * FROM T_CAR WHERE ID = #{id}")
    fun findById(@Param("id") carId: String): Car?

}
