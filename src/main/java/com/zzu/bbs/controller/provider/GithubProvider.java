package com.zzu.bbs.controller.provider;
/*
 * User:程成
 * Date:2021/4/22
 * Time:15:29
 * Description:使用okhttp进行模拟post请求
 */

import com.alibaba.fastjson.JSON;
import com.zzu.bbs.dto.AccessTokenDTO;
import com.zzu.bbs.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

//将类初试化到容器的上下文中
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
//        RequestBody body = RequestBody.Companion.create(JSON.toJSONString(accessTokenDTO),mediaType);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();

            //后期使用了Ctrl+alt+N进行变量重构
            String access_token = string.split("&")[0].split("=")[1];

            //输出得到的accessToken
            System.out.println(access_token);

            return access_token;
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("===========获取accessToken时出错了,在GithubProvider里===========");
        }
        return null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization", "token " + accessToken)
                .header("accept", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();

            //将String格式Json对象,解析为java类对象
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);

            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("===========获取用户信息时出错了,在GithubProvider里============");
        }
        return null;


    }
}
