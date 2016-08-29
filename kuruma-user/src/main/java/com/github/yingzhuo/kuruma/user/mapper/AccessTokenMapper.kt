package com.github.yingzhuo.kuruma.user.mapper

import com.github.yingzhuo.kuruma.common.entity.AccessToken
import org.apache.ibatis.annotations.*

@Mapper
interface AccessTokenMapper {

    @ResultMap("accessToken.base")
    @Select("SELECT * FROM T_ACCESS_TOKEN WHERE USER_ID = #{userId}")
    fun findByUserId(@Param("userId") userId: String): AccessToken?

    @Update("UPDATE T_ACCESS_TOKEN SET EXPIRED_TIME = #{expiredTime}, TOKEN = #{token} WHERE USER_ID = #{userId}")
    fun updateExpiredTimeAndToken(@Param("userId") userId: String, @Param("expiredTime") expiredTime: Long, @Param("token") token: String)

    @Insert("""
    INSERT INTO
        T_ACCESS_TOKEN
    VALUES (USER_ID, TOKEN, EXPIRED_TIME)
        (#{userId}, #{token}, #{expiredTime})
    """)
    fun saveAccessToken(accessToken: AccessToken)

}
