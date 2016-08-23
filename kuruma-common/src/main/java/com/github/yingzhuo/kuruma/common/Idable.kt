package com.github.yingzhuo.kuruma.common

import java.io.Serializable

interface Idable<out T : Serializable> : Serializable {

    val id: T?

}
