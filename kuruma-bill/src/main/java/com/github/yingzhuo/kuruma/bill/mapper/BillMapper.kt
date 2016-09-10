package com.github.yingzhuo.kuruma.bill.mapper

import com.github.yingzhuo.kuruma.common.entity.Bill
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Select

@Mapper
interface BillMapper {

    @ResultMap("bill.base")
    @Select("SELECT * FROM T_BILL WHERE ID = #{id}")
    fun findById(@Param("id") billId: String): Bill?

    @ResultMap("bill.base")
    @Select("SELECT * FROM T_BILL WHERE USER_ID = #{userId} ORDER BY CREATED_DATE DESC")
    fun findByUserId(@Param("userId") userId: String): List<Bill>

    @ResultMap("bill.base")
    @Select("SELECT * FROM T_BILL WHERE CAR_ID = #{carId} ORDER BY CREATED_DATE DESC")
    fun findByCarId(@Param("carId") carId: String): List<Bill>

}
