package com.github.yingzhuo.kuruma.bill.controller

import com.github.yingzhuo.kuruma.bill.service.BillService
import com.github.yingzhuo.kuruma.common.Json
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("bills")
open class BillController @Autowired constructor(val billService: BillService) {

    @GetMapping("{billId}")
    fun findById(@PathVariable("billId") billId: String): ResponseEntity<Json> {
        val bill = billService.findBillById(billId)
        return Json.create()
                .put("bill" to bill)
                .asResponseEntity()
    }

    @GetMapping("user/{userId}")
    fun findByUserId(@PathVariable("userId") userId: String): ResponseEntity<Json> {
        val bills = billService.findBillsByUserId(userId)
        return Json.create()
                .put("bills" to bills)
                .asResponseEntity()
    }

    @GetMapping("car/{carId}")
    fun findByCarId(@PathVariable("carId") carId: String): ResponseEntity<Json> {
        val bills = billService.findBillsByCarId(carId)
        return Json.create()
                .put("bills" to bills)
                .asResponseEntity()
    }

    @DeleteMapping("billId")
    fun deleteBills(@PathVariable("billId") billId: String): ResponseEntity<Json> {
        billService.deleteBillsByBillId(billId)
        return Json.create()
                .asResponseEntity()
    }

}
