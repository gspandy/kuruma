package com.github.yingzhuo.kuruma.common.entity

import com.github.yingzhuo.kuruma.common.AbstractToStringSupport
import com.github.yingzhuo.kuruma.common.Idable
import java.util.*

open class Bill : AbstractToStringSupport(), Idable<String> {

    /**
     * ID
     */
    override var id: String? = null

    /**
     * 金额
     */
    var sum: Double? = null

    /**
     * 说明
     */
    var comment: String? = null

    /**
     * 车辆ID
     */
    var carId: String? = null

    /**
     * 用户ID
     */
    var userId: String? = null

    /**
     * 创建时间
     */
    var createdDate: Date? = null

}
