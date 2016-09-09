package com.github.yingzhuo.kuruma.common

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import java.io.Serializable

class Json private constructor(val code: Int, val messages: Array<String>) : Serializable {

    private val _payload: MutableMap<String, Any> = mutableMapOf()
    val payload: Map<String, Any> get() = _payload

    companion object {
        fun create(status: HttpStatus = HttpStatus.OK, messages: Array<String> = arrayOf()): Json {
            return Json(status.value(), messages)
        }
    }

    fun put(key: String, value: Any): Json {
        _payload.put(key, value)
        return this
    }

    fun put(keyvalue: Pair<String, Any>): Json {
        _payload.put(keyvalue.first, keyvalue.second)
        return this
    }

    fun asResponseEntity(): ResponseEntity<Json> {
        val jsonHeaders = HttpHeaders()
        jsonHeaders.contentType = MediaType.APPLICATION_JSON_UTF8
        return ResponseEntity(this, jsonHeaders, HttpStatus.valueOf(code))
    }

}
