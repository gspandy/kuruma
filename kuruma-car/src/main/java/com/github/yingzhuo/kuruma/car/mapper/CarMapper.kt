package com.github.yingzhuo.kuruma.car.mapper

import com.github.yingzhuo.kuruma.common.entity.Car
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Select

@Mapper
interface CarMapper {

    @ResultMap("car.base")
    @Select("SELECT * FROM T_CAR WHERE ID = #{id}")
    fun findById(@Param("id") carId: String): Car?

    @ResultMap("car.base")
    @Select("SELECT * FROM T_CAR WHERE USER_ID = #{userId} ORDER BY CREATED_DATE DESC")
    fun findByUserId(@Param("userId") userId: String): List<Car>

}
