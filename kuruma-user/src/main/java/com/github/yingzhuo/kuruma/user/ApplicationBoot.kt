package com.github.yingzhuo.kuruma.user

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import javax.annotation.PostConstruct

@SpringBootApplication
open class ApplicationBoot {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ApplicationBoot::class.java)
    }

    @PostConstruct
    open fun init() {
        LOGGER.debug("'${ApplicationBoot::class.java.simpleName}'初始化")
    }
}


/**
 * 程序入口
 */
fun main(args: Array<String>) {
    SpringApplication.run(ApplicationBoot::class.java, *args)
}
