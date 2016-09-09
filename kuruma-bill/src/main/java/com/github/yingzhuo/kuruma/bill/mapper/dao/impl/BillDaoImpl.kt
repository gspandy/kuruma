package com.github.yingzhuo.kuruma.bill.mapper.dao.impl

import com.github.yingzhuo.kuruma.bill.mapper.BillMapper
import com.github.yingzhuo.kuruma.bill.mapper.dao.BillDao
import com.github.yingzhuo.kuruma.common.entity.Bill
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository("billDao")
open class BillDaoImpl @Autowired constructor(val billMapper: BillMapper) : BillDao {

    override fun findBillById(billId: String): Bill? = billMapper.findById(billId)

    override fun findBillsByUserId(userId: String): List<Bill> = billMapper.findByUserId(userId)

    override fun findBillsByCarId(carId: String): List<Bill> = billMapper.findByCarId(carId)

    override fun deleteByCarId(carId: String) {
        billMapper.deleteByCarId(carId)
    }

    override fun deleteByBillId(billId: String) {
        billMapper.deleteByBillId(billId)
    }

    override fun saveBill(bill: Bill) {
        billMapper.saveBill(bill)
    }

}
