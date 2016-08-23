package com.github.yingzhuo.kuruma.confserver.bean

import org.apache.commons.lang3.time.DateFormatUtils
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.core.env.Environment
import org.springframework.stereotype.Component
import java.util.*

@Component
open class LoggingApplicationRunner @Autowired constructor(val environment: Environment) : ApplicationRunner {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(LoggingApplicationRunner::class.java)
    }

    override fun run(args: ApplicationArguments) {
        LOGGER.info("-".repeat(80))
        LOGGER.info("情景模式:")
        LOGGER.info("\t\t{}", environment.activeProfiles.asList())
        LOGGER.info("启动时间:")
        LOGGER.info("\t\t{}", DateFormatUtils.format(Date(), "yyyy-MM-dd HH:mm:ss.SSS"))
        LOGGER.info("启动参数:")
        args.optionNames.forEach { LOGGER.info("\t\t{} = {}", it, args.getOptionValues(it)) }
        LOGGER.info("-".repeat(80))
    }

}
