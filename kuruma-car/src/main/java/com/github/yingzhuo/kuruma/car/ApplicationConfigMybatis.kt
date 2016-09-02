package com.github.yingzhuo.kuruma.car

import org.apache.ibatis.annotations.Mapper
import org.mybatis.spring.annotation.MapperScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import javax.sql.DataSource

@Configuration
@MapperScan(
        basePackages = arrayOf("com.github.yingzhuo.kuruma.car.mapper"),
        annotationClass = Mapper::class
)
@EnableTransactionManagement
open class ApplicationConfigMybatis {

    @Bean
    open fun txManager(dataSource: DataSource): PlatformTransactionManager {
        return DataSourceTransactionManager(dataSource)
    }
}
