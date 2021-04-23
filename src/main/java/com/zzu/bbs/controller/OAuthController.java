package com.zzu.bbs.controller;
/*
 * User:程成
 * Date:2021/4/22
 * Time:15:20
 * Description:GitHub登录回调控制器.
 */

import com.zzu.bbs.controller.provider.GithubProvider;
import com.zzu.bbs.dto.AccessTokenDTO;
import com.zzu.bbs.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OAuthController {

    //会自动将实例化好的东西放到该变量里
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String client_id;

    @Value("${github.client.secret}")
    private String client_secret;

    @Value("${github.redirect.uri}")
    private String redirect_uri;

    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);

        //登录后的回调地址
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        System.out.println(user.getId());
        System.out.println(user.getEmail());
        System.out.println(user.getBio());
        return "index";
    }
}
