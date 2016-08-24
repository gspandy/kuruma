package com.github.yingzhuo.kuruma.common.spring

inline fun ifProfileActived(profile: String, lambda: () -> Unit): Unit {
    val ps = SpringUtils.getActiveProfiles()

    if (profile in ps) {
        lambda()
    }
}

inline fun ifProfileActived(vararg profiles: String, lambda: () -> Unit): Unit {
    val ps = SpringUtils.getActiveProfiles()

    var call = true

    for (p in profiles) {
        if (p !in ps) {
            call = false
            break
        }
    }

    if (call) lambda()
}
