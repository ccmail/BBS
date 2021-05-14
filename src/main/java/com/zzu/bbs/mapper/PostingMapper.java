package com.zzu.bbs.mapper;
/*
 * User:程成
 * Date:2021/4/28
 * Time:22:29
 * Description:向数据库中插入新添加的帖子
 */

import com.zzu.bbs.model.Posting;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PostingMapper {

    @Insert("Insert into posting (title,description,gmt_create,gmt_modify,creator,tag) values (#{title},#{description},#{gmt_create},#{gmt_modify},#{creator},#{tag})")
    void create(Posting posting);

    @Select("select * from posting")
    List<Posting> selectAllPosting();

    @Select("select * from posting where creator=#{userId}")
    List<Posting> selectAllPostingByUser(@Param("userId") Integer userId);

    @Select("select * from posting where id=#{userId}")
    Posting getPostingById(@Param("userId") Integer userId);

    @Update("update posting set title=#{title},description=#{description},gmt_modify=#{gmt_modify},tag=#{tag} where id = #{id}")
    void update(Posting posting);
}
