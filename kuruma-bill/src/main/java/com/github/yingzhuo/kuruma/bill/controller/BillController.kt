package com.github.yingzhuo.kuruma.bill.controller

import com.github.yingzhuo.kuruma.bill.service.BillService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("bills")
open class BillController @Autowired constructor(val billService: BillService) {

}
