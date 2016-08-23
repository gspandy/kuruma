package com.github.yingzhuo.kuruma.user.mapper.contoller

import com.github.yingzhuo.kuruma.user.Profiles
import org.springframework.context.annotation.Profile
import org.springframework.web.bind.annotation.RestController

@RestController
@Profile(Profiles.LOCAL)
open class LocalTestingController {

}
