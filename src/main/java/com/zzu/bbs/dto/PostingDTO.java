package com.zzu.bbs.dto;
/*
 * User:程成
 * Date:2021/5/7
 * Time:21:01
 * Description:
 */

import com.zzu.bbs.model.User;
import lombok.Data;

@Data
public class PostingDTO {
    private Integer id;
    private String title;
    private String description;
    private String  tag;
    private Long gmt_create;
    private Long gmt_modify;
    private Integer creator;
    private Integer view_count;
    private Integer comment_count;
    private Integer like_count;
    private Integer dislike_count;
    private User user;
}
