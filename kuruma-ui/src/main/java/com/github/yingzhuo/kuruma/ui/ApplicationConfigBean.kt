package com.github.yingzhuo.kuruma.ui

import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate

@Configuration
open class ApplicationConfigBean {

    @Bean
    @LoadBalanced
    open fun restTemplate(): RestTemplate = RestTemplate()

}