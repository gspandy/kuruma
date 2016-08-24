package com.github.yingzhuo.kuruma.user.controller.request

import com.github.yingzhuo.kuruma.common.Gender
import com.github.yingzhuo.kuruma.common.uuid
import java.io.Serializable
import java.util.*

open class UserRequest : Serializable {

    /**
     * ID
     */
    var id: String? = null

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

    init {
        id = uuid()
    }

}
