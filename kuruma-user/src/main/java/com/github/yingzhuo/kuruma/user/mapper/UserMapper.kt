package com.github.yingzhuo.kuruma.user.mapper

import com.github.yingzhuo.kuruma.common.entity.User
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param
import org.apache.ibatis.annotations.Select

@Mapper
interface UserMapper {

    @Select("SELECT * FROM T_USER WHERE ID = #{id}")
    fun findById(@Param("id") id: String): User?

}
