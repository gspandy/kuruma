package com.github.yingzhuo.kuruma.user.controller.request

import com.github.yingzhuo.kuruma.common.Gender
import com.github.yingzhuo.kuruma.common.uuid
import com.github.yingzhuo.kuruma.common.validate.Create
import com.github.yingzhuo.kuruma.common.validate.Update
import org.hibernate.validator.constraints.Length
import java.io.Serializable
import javax.validation.constraints.NotNull

open class UserRequest : Serializable {

    /**
     * ID
     */
    @Length(min = 32, max = 32, groups = arrayOf(Update::class), message = "ID长度必须在{min}与{max}之间")
    var id: String? = null

    /**
     * 名字
     */
    @Length(min = 2, max = 20, groups = arrayOf(Update::class, Create::class), message = "名字长度必须在{min}与{max}之间")
    var name: String? = null

    /**
     * 性别
     */
    @NotNull(groups = arrayOf(Create::class), message = "性别不可为空")
    var gender: Gender? = null

    /**
     * 登录密码
     */
    @NotNull(groups = arrayOf(Create::class), message = "密码不可为空")
    @Length(min = 6, max = 12, groups = arrayOf(Update::class, Create::class), message = "密码长度必须在{min}与{max}之间")
    var password: String? = null


    init {
        id = uuid()
    }

    override fun toString(): String{
        return "UserRequest(id=$id, name=$name, gender=$gender, newPassword=$password"
    }

}
