package com.github.yingzhuo.kuruma.common.exception

/**
 * 业务异常
 */
open class BusinessException constructor(
        override val message: String? = null,
        override val cause: Exception? = null
) : RuntimeException(message, cause) {

}

/**
 * 资源没有找到异常
 */
open class ResourceNotFoundException(message: String? = null) : BusinessException(message)

/**
 * 错误的请求异常
 */
open class BadRequestException(message: String? = null): BusinessException(message)
