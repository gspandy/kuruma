package com.github.yingzhuo.kuruma.common.entity

import com.github.yingzhuo.kuruma.common.AbstractToStringSupport
import com.github.yingzhuo.kuruma.common.Idable

open class Car : AbstractToStringSupport(), Idable<String> {

    /**
     * ID
     */
    override var id: String? = null

    /**
     * 名称
     */
    var name: String? = null

    /**
     * 牌照
     */
    var licence: String? = null

    /**
     * 其他
     */
    var description: String? = null

}