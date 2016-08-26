package com.github.yingzhuo.kuruma.user.password

import org.apache.commons.codec.digest.DigestUtils

@FunctionalInterface
interface PasswordHasher {

    companion object {
        val DEFAULT = object : PasswordHasher {
            override fun hash(rawPassword: String): String = DigestUtils.md5Hex(rawPassword)
        }
    }

    fun hash(rawPassword: String): String
}