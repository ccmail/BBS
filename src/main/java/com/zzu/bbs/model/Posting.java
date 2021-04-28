package com.zzu.bbs.model;
/*
 * User:程成
 * Date:2021/4/28
 * Time:22:35
 * Description:
 */

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Posting {

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
}
