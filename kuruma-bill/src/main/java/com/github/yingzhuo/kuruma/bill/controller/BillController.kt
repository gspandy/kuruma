package com.github.yingzhuo.kuruma.bill.controller

import com.github.yingzhuo.kuruma.bill.controller.request.BillRequest
import com.github.yingzhuo.kuruma.bill.service.BillService
import com.github.yingzhuo.kuruma.common.Json
import com.github.yingzhuo.kuruma.common.exception.BadRequestException
import com.github.yingzhuo.kuruma.common.validate.Create
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
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

    @PostMapping
    fun createBill(@Validated(Create::class) billRequest: BillRequest, bindingResult: BindingResult): ResponseEntity<Json> {

        if (bindingResult.hasErrors()) {
            throw BadRequestException(bindingResult.allErrors)
        }

        val bill = billService.saveBill(billRequest)
        return Json.create(HttpStatus.CREATED)
                .put("bill" to bill)
                .asResponseEntity()
    }

}
