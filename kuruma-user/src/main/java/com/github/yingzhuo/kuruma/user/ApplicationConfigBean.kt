package com.github.yingzhuo.kuruma.user

import com.github.yingzhuo.kuruma.common.spring.SpringUtils
import com.github.yingzhuo.kuruma.user.password.PasswordHasher
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ApplicationConfigBean {

    @Bean
    open fun springUtils(): SpringUtils {
        return SpringUtils()
    }

    @Bean
    open fun passwordHasher(): PasswordHasher {
        return PasswordHasher.DEFAULT
    }

}