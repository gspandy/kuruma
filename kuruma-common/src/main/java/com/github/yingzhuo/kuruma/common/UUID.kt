package com.github.yingzhuo.kuruma.common

import java.util.*

/**
 * 生成随机UUID
 */
fun uuid(shortVersion: Boolean = true): String {
    val uuid = UUID.randomUUID().toString().toLowerCase()
    return if (shortVersion) uuid.replace("-", "") else uuid
}
