package com.github.yingzhuo.kuruma.ui.cli

import com.github.yingzhuo.kuruma.common.entity.Bill
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("KURUMA-BILL")
interface BillClient {

    @RequestMapping("bills/user/{userId}", method = arrayOf(RequestMethod.GET))
    fun findBillsByUserId(@PathVariable("userId") userId: String): Array<Bill>

}
