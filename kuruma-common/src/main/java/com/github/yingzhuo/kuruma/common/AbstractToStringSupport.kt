package com.github.yingzhuo.kuruma.common

import org.apache.commons.lang3.builder.ReflectionToStringBuilder
import org.apache.commons.lang3.builder.ToStringStyle

abstract open class AbstractToStringSupport {

    override fun toString(): String {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE)
    }

}
