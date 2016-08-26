package com.github.yingzhuo.kuruma.common.entity

import java.io.Serializable

data class AccessToken(
        var userId: String? = null,
        var token: String? = null,
        var expiredTime: Long? = null) : Serializable {
}
