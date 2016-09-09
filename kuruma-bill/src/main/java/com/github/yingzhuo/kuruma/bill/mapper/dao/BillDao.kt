package com.github.yingzhuo.kuruma.bill.mapper.dao

import com.github.yingzhuo.kuruma.common.entity.Bill

interface BillDao {

    fun findBillById(billId: String): Bill?

    fun findBillsByUserId(userId: String): List<Bill>

    fun findBillsByCarId(carId: String): List<Bill>

    fun deleteByCarId(carId: String)

    fun deleteByBillId(billId: String)

    fun saveBill(bill: Bill)

}
