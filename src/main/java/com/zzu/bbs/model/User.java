package com.zzu.bbs.model;
/*
 * User:程成
 * Date:2021/4/24
 * Time:23:28
 * Description:
 */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {


    private Integer id;
    private String name;
    private String account_id;
    private String token;
    private Long gmt_create;
    private Long gmt_modify;
}
