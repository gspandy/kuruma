package com.github.yingzhuo.kuruma.apigateway

import org.apache.commons.lang3.time.DateFormatUtils
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy
import org.springframework.core.Ordered
import org.springframework.core.env.Environment
import java.util.*

const val APP: String = "kuruma-apigateway"

@EnableZuulProxy
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication
open class ApplicationBoot @Autowired constructor(val env: Environment) : ApplicationRunner, Ordered {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ApplicationBoot::class.java)
    }

    override fun getOrder() = org.springframework.core.Ordered.LOWEST_PRECEDENCE

    override fun run(args: ApplicationArguments) {
        LOGGER.info("-".repeat(80))
        LOGGER.info("应用:")
        LOGGER.info("\t\t{}", APP)
        LOGGER.info("情景模式:")
        LOGGER.info("\t\t{}", env.activeProfiles.asList())
        LOGGER.info("启动时间:")
        LOGGER.info("\t\t{}", DateFormatUtils.format(Date(), "yyyy-MM-dd HH:mm:ss.SSS"))
        LOGGER.info("启动参数:")
        args.optionNames.forEach { LOGGER.info("\t\t{} = {}", it, args.getOptionValues(it)) }
        LOGGER.info("-".repeat(80))
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(ApplicationBoot::class.java, *args)
}
