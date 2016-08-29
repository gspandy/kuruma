package com.github.yingzhuo.kuruma.common.spring

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.EnvironmentAware
import org.springframework.core.env.Environment

class SpringUtils : EnvironmentAware, ApplicationContextAware {

    companion object {
        private var applicationContext: ApplicationContext? = null
        private var environment: Environment? = null

        fun getContainer(): ApplicationContext = applicationContext!!

        fun getActiveProfiles(): Set<String> = setOf<String>(*(environment!!.activeProfiles))
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
