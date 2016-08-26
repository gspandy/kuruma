package com.github.yingzhuo.kuruma.user

import com.github.yingzhuo.kuruma.user.mapper.AccessTokenMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
open class TestingApplicationRunner @Autowired constructor(val accessTokenMapper: AccessTokenMapper) : ApplicationRunner {

    override fun run(args: ApplicationArguments?) {
        val at = accessTokenMapper.findByUserId("1")
        println(at)
    }

}