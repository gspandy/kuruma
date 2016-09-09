package com.github.yingzhuo.kuruma.bill.service

import com.github.yingzhuo.kuruma.bill.controller.request.BillRequest
import com.github.yingzhuo.kuruma.common.entity.Bill
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

interface BillService {

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    fun findBillById(billId: String): Bill

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    fun findBillsByUserId(userId: String): List<Bill>

    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    fun findBillsByCarId(carId: String): List<Bill>

    @Transactional(propagation = Propagation.REQUIRED)
    fun deleteBillsByCarId(carId: String)

    @Transactional(propagation = Propagation.REQUIRED)
    fun deleteBillsByBillId(billId: String)

    @Transactional(propagation = Propagation.REQUIRED)
    fun saveBill(billRequest: BillRequest): Bill

}
