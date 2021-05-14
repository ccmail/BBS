package com.zzu.bbs.mapper;
/*
 * User:程成
 * Date:2021/4/24
 * Time:23:22
 * Description:user的mapper映射文件
 */

import com.zzu.bbs.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modify,avatar_url) values(#{name},#{account_id},#{token},#{gmt_create},#{gmt_modify},#{avatar_url})")
    void insert(User user);

    @Select("select * from user where token = #{token_value}")
    User findByToken(@Param("token_value") String token_value);

    @Select("select * from user where id=#{id}")
    User findById(@Param("id") Integer id);

    @Select("select * from user where account_id=#{account_id}")
    User findByAccountId(@Param("account_id") String account_id);

    @Update("Update user set name=#{name},token=#{token},gmt_modify=#{gmt_modify},avatar_url=#{avatar_url} where id=#{id}")
    void update(User user);
}
