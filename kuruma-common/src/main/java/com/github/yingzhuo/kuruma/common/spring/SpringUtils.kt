package com.github.yingzhuo.kuruma.common.spring

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.EnvironmentAware
import org.springframework.core.env.Environment
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import javax.servlet.http.HttpSession

class SpringUtils : EnvironmentAware, ApplicationContextAware {

    companion object {
        private var applicationContext: ApplicationContext? = null
        private var environment: Environment? = null

        fun getContainer(): ApplicationContext = applicationContext!!

        fun getEnv(): Environment = environment!!

        fun getActiveProfiles(): Set<String> = setOf<String>(*(environment!!.activeProfiles))

        fun getRequest(): HttpServletRequest {
            val attribute = RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes
            return attribute.request
        }

        fun getResponse(): HttpServletResponse {
            val attribute = RequestContextHolder.currentRequestAttributes() as ServletRequestAttributes
            return attribute.response
        }

        fun getSession(create: Boolean = true): HttpSession {
            return getRequest().getSession(create)
        }
    }

    override fun setEnvironment(environment: Environment) {
        if (SpringUtils.environment == null)
            SpringUtils.environment = environment
    }

    override fun setApplicationContext(applicationContext: ApplicationContext?) {
        if (SpringUtils.applicationContext == null)
            SpringUtils.applicationContext = applicationContext
    }

}
