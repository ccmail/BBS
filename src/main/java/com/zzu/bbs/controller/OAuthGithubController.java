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
import com.zzu.bbs.mapper.UserMapper;
import com.zzu.bbs.model.User;
import com.zzu.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class OAuthGithubController {

    //会自动将实例化好的东西放到该变量里
    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserService userService;

    @Value("${github.client.id}")
    private String client_id;

    @Value("${github.client.secret}")
    private String client_secret;

    @Value("${github.redirect.uri}")
    private String redirect_uri;


    @GetMapping("/callback")
    public String callBack(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request,
                           HttpServletResponse response) {
        //Spring自动将session放到request中

        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);

        //登录后的回调地址
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);

        //获取user信息
        String accessToken = githubProvider.getAccessToken(accessTokenDTO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        System.out.println(githubUser.getName());
        System.out.println(githubUser.getId());
        System.out.println(githubUser.getEmail());
        System.out.println(githubUser.getBio());

        //进行登录状态的判断
        if (githubUser != null && githubUser.getId() != null) {
            //登录成功,获取cookies和session
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setName(githubUser.getName());
            user.setAccount_id(String.valueOf(githubUser.getId()));
            user.setAvatar_url(githubUser.getAvatar_url());

            userService.createOrUpdate(user);


            //写入cookie,将token写入cookie
            response.addCookie(new Cookie("token", token));


            request.getSession().setAttribute("user", githubUser);
            //获取session时,springBoot会自动发放cookies


            return "redirect:/";
        } else {
            //登陆失败,需要进行重新登陆
            return "redirect:/";

        }


    }

    @GetMapping("/signOut")
    public String signOut(HttpServletRequest request,
                          HttpServletResponse response) {
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
}
