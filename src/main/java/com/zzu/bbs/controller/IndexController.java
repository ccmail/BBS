package com.zzu.bbs.controller;
/*
 * User:程成
 * Date:2021/4/21
 * Time:15:01
 * Description:第一个SpringMvc类,该文件用于将请求的信息添加到model中, 返回给GetMapping对应的html模板页面
 */

import com.zzu.bbs.mapper.UserMapper;
import com.zzu.bbs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")) {
                String token_value = cookie.getValue();
                User user = userMapper.findByToken(token_value);
                if (user != null) {
                    request.getSession().setAttribute("user",user);
                }

                break;
            }
        }

        return "index";
    }
}
