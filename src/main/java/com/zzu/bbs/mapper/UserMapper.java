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

@Mapper
public interface UserMapper {

    @Insert("insert into user(name,account_id,token,gmt_create,gmt_modify) values(#{name},#{account_id},#{token},#{gmt_create},#{gmt_modify})")
    void insert(User user);

}
