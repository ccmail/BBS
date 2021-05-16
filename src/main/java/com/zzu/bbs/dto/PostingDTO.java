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
    private Long id;
    private String title;
    private String description;
    private String  tag;
    private Long gmtCreate;
    private Long gmtModify;
    private Integer creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private Integer dislikeCount;
    private User user;
}
