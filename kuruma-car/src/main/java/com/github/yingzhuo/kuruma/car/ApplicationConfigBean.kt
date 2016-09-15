package com.github.yingzhuo.kuruma.car

import com.github.yingzhuo.kuruma.common.endpoint.FingerprintEndpoint
import com.github.yingzhuo.kuruma.common.spring.SpringUtils
import org.springframework.boot.actuate.endpoint.Endpoint
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ApplicationConfigBean {

    @Bean
    open fun springUtils(): SpringUtils = SpringUtils()

    @Bean
    open fun fingerprintEndpoint(): Endpoint<String> = FingerprintEndpoint()

}
