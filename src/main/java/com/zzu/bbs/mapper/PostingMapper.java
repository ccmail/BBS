package com.zzu.bbs.mapper;
/*
 * User:程成
 * Date:2021/4/28
 * Time:22:29
 * Description:向数据库中插入新添加的帖子
 */

import com.zzu.bbs.model.Posting;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostingMapper {

    @Insert("Insert into posting (title,description,gmt_create,gmt_modify,creator,tag) values (#{title},#{description},#{gmt_create},#{gmt_modify},#{creator},#{tag})")
    void create(Posting posting);
}
