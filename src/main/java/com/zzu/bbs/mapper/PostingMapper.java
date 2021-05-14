package com.zzu.bbs.mapper;

import com.zzu.bbs.model.Posting;
import com.zzu.bbs.model.PostingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PostingMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    int countByExample(PostingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    int deleteByExample(PostingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    int insert(Posting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    int insertSelective(Posting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    List<Posting> selectByExampleWithBLOBsWithRowbounds(PostingExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    List<Posting> selectByExampleWithBLOBs(PostingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    List<Posting> selectByExampleWithRowbounds(PostingExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    List<Posting> selectByExample(PostingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    Posting selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    int updateByExampleSelective(@Param("record") Posting record, @Param("example") PostingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    int updateByExampleWithBLOBs(@Param("record") Posting record, @Param("example") PostingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    int updateByExample(@Param("record") Posting record, @Param("example") PostingExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    int updateByPrimaryKeySelective(Posting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    int updateByPrimaryKeyWithBLOBs(Posting record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table posting
     *
     * @mbggenerated Sat May 15 00:48:06 CST 2021
     */
    int updateByPrimaryKey(Posting record);
}