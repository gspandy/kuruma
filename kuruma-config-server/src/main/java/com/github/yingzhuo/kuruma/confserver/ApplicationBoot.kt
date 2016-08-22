package com.github.yingzhuo.kuruma.confserver

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.config.server.EnableConfigServer
import javax.annotation.PostConstruct

@EnableConfigServer
@SpringBootApplication
open class ApplicationBoot {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ApplicationBoot::class.java)
    }

    @PostConstruct
    open fun init() {
        LOGGER.debug("${ApplicationBoot::class.java.simpleName} init ...")
    }

}

/**
 * 程序入口
 */
fun main(args: Array<String>) {
    SpringApplication.run(ApplicationBoot::class.java, *args)
}
