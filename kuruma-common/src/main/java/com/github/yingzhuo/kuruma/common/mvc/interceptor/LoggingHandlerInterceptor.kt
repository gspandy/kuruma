package com.github.yingzhuo.kuruma.common.mvc.interceptor

import org.apache.commons.lang3.StringUtils
import org.slf4j.LoggerFactory
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class LoggingHandlerInterceptor private constructor() : HandlerInterceptorAdapter() {

    companion object {
        val INSTANCE: HandlerInterceptor = LoggingHandlerInterceptor()

        private val LOGGER = LoggerFactory.getLogger(LoggingHandlerInterceptor::class.java)

        private val BARS = "=".repeat(80)
    }

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        LOGGER.trace(BARS)
        LOGGER.trace("[URI]: ")
        LOGGER.trace("\t\t\t{}", request.requestURI)

        LOGGER.trace("[METHOD]: ")
        LOGGER.trace("\t\t\t{}", request.method)

        LOGGER.trace("[HEADERS]: ")
        val headerNames = request.headerNames
        while (headerNames.hasMoreElements()) {
            val name = headerNames.nextElement()
            val value = request.getHeader(name)
            LOGGER.trace("\t\t\t{} = {}", name, if (name.equals("cookie", true)) StringUtils.abbreviate(value, 60) else value)
        }

        LOGGER.trace("[PARAMETERS]: ")
        val paramNames = request.parameterNames
        while (paramNames.hasMoreElements()) {
            val name = paramNames.nextElement()
            val value = request.getParameter(name)
            LOGGER.trace("\t\t\t{} = {}", name, value)
        }

        LOGGER.trace(BARS)
        return true
    }

}
