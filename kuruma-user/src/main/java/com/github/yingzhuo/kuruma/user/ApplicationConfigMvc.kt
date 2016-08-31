package com.github.yingzhuo.kuruma.user

import com.github.yingzhuo.kuruma.common.mvc.interceptor.LoggingHandlerInterceptor
import org.springframework.context.annotation.Configuration
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter
import org.springframework.web.util.UrlPathHelper

@Configuration
open class ApplicationConfigMvc : WebMvcConfigurerAdapter() {

    override fun configureDefaultServletHandling(configurer: DefaultServletHandlerConfigurer) {
        configurer.enable()
    }

    override fun configurePathMatch(configurer: PathMatchConfigurer) {
        val helper = UrlPathHelper()
        helper.setRemoveSemicolonContent(false)
        helper.setDefaultEncoding("UTF-8")
        configurer.urlPathHelper = helper
    }

    override fun addArgumentResolvers(argumentResolvers: MutableList<HandlerMethodArgumentResolver>) {

    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(LoggingHandlerInterceptor.INSTANCE)
                .addPathPatterns("/**")
                .excludePathPatterns("/**/*.ico", "/**/*.js", "/**/*.css")
    }
}
