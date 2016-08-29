package com.github.yingzhuo.kuruma.user.mapper

import com.github.yingzhuo.kuruma.common.Gender
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
        (#{id}, #{name}, #{gender}, #{newPassword}, #{regiesterDate} )
    """)
    fun save(user: User)

    @Select("SELECT ID FROM T_USER WHERE NAME = #{name} AND PASSWORD = #{pwd}")
    fun testPassword(@Param("name") name: String, @Param("pwd") password: String): String?

    @Select("SELECT COUNT(*) <> 0 FROM T_USER WHERE ID = #{id} AND PASSWORD = #{pwd}")
    fun testPasswordById(@Param("id") userId: String, @Param("pwd") password: String): Boolean

    @Update("""
    UPDATE
        T_USER
    SET
        GENDER = #{gender}
    WHERE
        ID = #{userId}
    """)
    fun updateGender(@Param("userId") userId: String, @Param("gender") gender: Gender)

    @Update("""
    UPDATE
        T_USER
    SET
        PASSWORD = #{newPassword}
    WHERE
        ID = #{userId}
    """)
    fun updatePassword(@Param("userId") userId: String, @Param("newPassword") password: String)

}
