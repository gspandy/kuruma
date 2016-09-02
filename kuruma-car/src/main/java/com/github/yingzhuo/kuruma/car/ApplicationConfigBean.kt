package com.github.yingzhuo.kuruma.car

import com.github.yingzhuo.kuruma.common.spring.SpringUtils
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ApplicationConfigBean {

    @Bean
    open fun springUtils(): SpringUtils {
        return SpringUtils()
    }

}
