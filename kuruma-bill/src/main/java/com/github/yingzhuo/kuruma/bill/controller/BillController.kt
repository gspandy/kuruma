package com.github.yingzhuo.kuruma.bill.controller

import com.github.yingzhuo.kuruma.bill.service.BillService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("bills")
open class BillController @Autowired constructor(val billService: BillService) {

    @GetMapping("{billId}")
    fun findById(@PathVariable("billId") billId: String): Any {
        val bill = billService.findBillById(billId)
        return bill
    }

    @GetMapping("user/{userId}")
    fun findByUserId(@PathVariable("userId") userId: String): Any {
        val bills = billService.findBillsByUserId(userId)
        return bills
    }

    @GetMapping("car/{carId}")
    fun findByCarId(@PathVariable("carId") carId: String): Any {
        val bills = billService.findBillsByCarId(carId)
        return bills
    }

}
