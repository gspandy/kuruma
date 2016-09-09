package com.github.yingzhuo.kuruma.bill.controller.request

import java.io.Serializable

open class BillRequest : Serializable {

    var sum: Double? = null
    var comment: String? = null
    var carId: String? = null
    var userId: String? = null

}
