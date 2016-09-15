package com.github.yingzhuo.kuruma.ui.cli

import com.github.yingzhuo.kuruma.common.entity.Car
import org.springframework.cloud.netflix.feign.FeignClient
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod

@FeignClient("KURUMA-CAR")
interface CarClient {

    @RequestMapping("cars/user/{userId}", method = arrayOf(RequestMethod.GET))
    fun findCarsByUserId(@PathVariable("userId") userId: String): Array<Car>

}
