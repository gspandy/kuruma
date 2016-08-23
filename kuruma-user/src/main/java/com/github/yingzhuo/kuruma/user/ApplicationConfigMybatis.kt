package com.github.yingzhuo.kuruma.user

import org.apache.ibatis.annotations.Mapper
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@MapperScan(
        basePackages = arrayOf("com.github.yingzhuo.kuruma.user.mapper"),
        annotationClass = Mapper::class
)
@EnableTransactionManagement
open class ApplicationConfigMybatis {

}
