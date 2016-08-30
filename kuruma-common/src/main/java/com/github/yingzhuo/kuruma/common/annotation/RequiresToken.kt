package com.github.yingzhuo.kuruma.common.annotation

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Deprecated(message = "暂不使用", level = DeprecationLevel.HIDDEN)
annotation class RequiresToken
