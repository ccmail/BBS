package com.zzu.bbs.dto;
/*
 * User:程成
 * Date:2021/4/22
 * Time:15:32
 * Description: AccessToken的实体类,用于传输数据
 */

import lombok.Data;

@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
