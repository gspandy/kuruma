package com.github.yingzhuo.kuruma.confserver

import org.apache.commons.lang3.time.DateFormatUtils
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.core.env.Environment
import java.util.*
import javax.annotation.PostConstruct

@EnableConfigServer
@SpringBootApplication
open class ApplicationBoot constructor(val env: Environment) : ApplicationRunner {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ApplicationBoot::class.java)
    }

    @PostConstruct
    open fun init() {
        LOGGER.debug("'${ApplicationBoot::class.java.simpleName}'初始化")
    }

    override fun run(args: ApplicationArguments) {
        LOGGER.info("-".repeat(80))
        LOGGER.info("情景模式:")
        LOGGER.info("\t\t{}", env.activeProfiles.asList())
        LOGGER.info("启动时间:")
        LOGGER.info("\t\t{}", DateFormatUtils.format(Date(), "yyyy-MM-dd HH:mm:ss.SSS"))
        LOGGER.info("启动参数:")
        args.optionNames.forEach { LOGGER.info("\t\t{} = {}", it, args.getOptionValues(it)) }
        LOGGER.info("-".repeat(80))
    }
}

/**
 * 程序入口
 */
fun main(args: Array<String>) {
    SpringApplication.run(ApplicationBoot::class.java, *args)
}
