package com.github.yingzhuo.kuruma.user.bean

import com.github.yingzhuo.kuruma.common.entity.User
import com.github.yingzhuo.kuruma.user.Profiles
import com.github.yingzhuo.kuruma.user.mapper.UserMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
@Profile(Profiles.LOCAL)
open class TestingCmdLineRunner @Autowired constructor(val userMapper: UserMapper) : CommandLineRunner {

    override fun run(vararg args: String) {
        val user: User? = userMapper.findById("1")
        println(user)
    }

}
