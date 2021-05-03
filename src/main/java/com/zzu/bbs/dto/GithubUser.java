package com.zzu.bbs.dto;
/*
 * User:程成
 * Date:2021/4/23
 * Time:13:39
 * Description:
 */

import lombok.Data;

@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String email;
    private String avatar_url;
}
