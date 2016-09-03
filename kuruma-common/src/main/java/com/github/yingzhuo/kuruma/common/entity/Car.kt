package com.github.yingzhuo.kuruma.common.entity

import com.github.yingzhuo.kuruma.common.AbstractToStringSupport
import com.github.yingzhuo.kuruma.common.Idable
import java.util.*

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

    /**
     * 用户ID
     */
    var userId: String? = null

    /**
     * 创建日期
     */
    var createdDate: Date? = null

}
