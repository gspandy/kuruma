package com.github.yingzhuo.kuruma.car.controller.request

import com.github.yingzhuo.kuruma.common.validate.Create
import com.github.yingzhuo.kuruma.common.validate.Update
import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotNull

class CarRequest {

    @NotNull(message = "车辆名称不可为空", groups = arrayOf(Create::class))
    @Length(min = 4, max = 20, message = "车辆名称长度必须在{min}和{max}", groups = arrayOf(Create::class, Update::class))
    var name: String? = null

    @Length(min = 7, max = 7, message = "车牌号长度必须在{min}", groups = arrayOf(Create::class, Update::class))
    var licence: String? = null

    @Length(min = 2, max = 20, message = "备注长度必须在{min}和{max}之间", groups = arrayOf(Create::class, Update::class))
    var description: String? = null

    @NotNull(message = "用户ID不可为空", groups = arrayOf(Create::class))
    @Length(min = 32, max = 32, message = "用户ID长度必须为{min}", groups = arrayOf(Create::class))
    var userId: String? = null

}
