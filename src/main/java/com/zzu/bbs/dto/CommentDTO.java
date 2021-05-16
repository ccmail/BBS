package com.zzu.bbs.dto;
/*
 * User:程成
 * Date:2021/5/16
 * Time:22:19
 * Description:
 */

import lombok.Data;

@Data
public class CommentDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
