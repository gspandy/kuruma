package com.github.yingzhuo.kuruma.common.endpoint

import org.springframework.boot.actuate.endpoint.AbstractEndpoint
import java.util.*

open class FingerprintEndpoint(id: String = "fingerprint", sensitive: Boolean = false) : AbstractEndpoint<String>(id, sensitive) {

    private val fingerprint: String = UUID.randomUUID().toString()

    override fun invoke(): String = fingerprint

    override fun toString(): String {
        return fingerprint
    }

}
