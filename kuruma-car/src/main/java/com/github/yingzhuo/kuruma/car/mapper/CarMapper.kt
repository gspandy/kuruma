package com.github.yingzhuo.kuruma.car.mapper

import com.github.yingzhuo.kuruma.common.entity.Car
import org.apache.ibatis.annotations.*

@Mapper
interface CarMapper {

    @Select("SELECT COUNT(ID) FROM T_CAR WHERE ID = #{id}")
    fun existsById(@Param("id") carId: String): Boolean

    @ResultMap("car.base")
    @Select("SELECT * FROM T_CAR WHERE ID = #{id}")
    fun findById(@Param("id") carId: String): Car?

    @ResultMap("car.base")
    @Select("SELECT * FROM T_CAR WHERE USER_ID = #{userId} ORDER BY CREATED_DATE DESC")
    fun findByUserId(@Param("userId") userId: String): List<Car>

    @Insert("""
    INSERT INTO
        T_CAR(ID, NAME, LICENCE, DESCRIPTION, USER_ID, CREATED_DATE)
    VALUES
        (#{id}, #{name}, #{licence}, #{description}, #{userId}, #{createdDate})
    """)
    fun saveCar(car: Car): Unit

    @Update("UPDATE T_CAR SET NAME = #{name} WHERE ID = #{id}")
    fun updateCarName(@Param("id") id: String, @Param("name") name: String): Unit

    @Update("UPDATE T_CAR SET DESCRIPTION = #{description} WHERE ID = #{id}")
    fun updateCarDescription(@Param("id") id: String, @Param("description") description: String): Unit

    @Update("UPDATE T_CAR SET LICENCE = #{licence} WHERE ID = #{id}")
    fun updateCarLicence(@Param("id") id: String, @Param("licence") licence: String): Unit

}
