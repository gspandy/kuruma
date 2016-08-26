package com.github.yingzhuo.kuruma.user.mapper

import com.github.yingzhuo.kuruma.common.entity.User
import org.apache.ibatis.annotations.*

@Mapper
interface UserMapper {

    @ResultMap("user.base")
    @Select("SELECT * FROM T_USER WHERE ID = #{id}")
    fun findById(@Param("id") id: String): User?

    @Insert("""
    INSERT INTO T_USER
        (ID, NAME, GENDER, PASSWORD, REGIESTER_DATE)
    VALUES
        (#{id}, #{name}, #{gender}, #{password}, #{regiesterDate} )
    """)
    fun save(user: User)

    @Select("SELECT ID FROM T_USER WHERE NAME = #{name} AND PASSWORD = #{password}")
    fun testPassword(@Param("name") name: String, @Param("password") password: String): String?

}
