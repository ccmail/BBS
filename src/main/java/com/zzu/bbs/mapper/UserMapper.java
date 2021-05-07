package com.zzu.bbs.mapper;
/*
 * User:程成
 * Date:2021/4/24
 * Time:23:22
 * Description:user的mapper映射文件
 */

import com.zzu.bbs.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modify,avatar_url) values(#{name},#{account_id},#{token},#{gmt_create},#{gmt_modify},#{avatar_url})")
    void insert(User user);

    @Select("select * from user where token = #{token_value}")
    User findByToken(@Param("token_value") String token_value);

    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Integer id);
}
