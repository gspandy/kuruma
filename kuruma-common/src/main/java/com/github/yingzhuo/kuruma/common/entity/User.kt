package com.github.yingzhuo.kuruma.common.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.github.yingzhuo.kuruma.common.AbstractToStringSupport
import com.github.yingzhuo.kuruma.common.Gender
import com.github.yingzhuo.kuruma.common.Idable
import java.util.*

@JsonIgnoreProperties("password")
open class User : AbstractToStringSupport(), Idable<String> {

    /**
     * ID
     */
    override var id: String? = null

    /**
     * 名字
     */
    var name: String? = null

    /**
     * 性别
     */
    var gender: Gender? = null

    /**
     * 登录密码
     */
    var password: String? = null

    /**
     * 注册时间
     */
    var regiesterDate: Date? = null

}
