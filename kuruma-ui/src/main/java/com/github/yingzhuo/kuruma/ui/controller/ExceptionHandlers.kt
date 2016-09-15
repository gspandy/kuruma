package com.github.yingzhuo.kuruma.ui.controller

import com.github.yingzhuo.kuruma.common.Json
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
open class ExceptionHandlers {

    companion object {
        private val LOGGER = LoggerFactory.getLogger(ExceptionHandlers::class.java)
    }

    @ExceptionHandler(Exception::class)
    open fun handleException(ex: Exception): ResponseEntity<Json> {
        val messages =
                if (ex.message != null)
                    arrayOf(ex.message!!)
                else
                    arrayOf()

        LOGGER.warn(ex.message, ex)
        return Json.create(HttpStatus.INTERNAL_SERVER_ERROR, messages).asResponseEntity()
    }

}