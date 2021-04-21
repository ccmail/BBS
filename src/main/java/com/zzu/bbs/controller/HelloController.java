package com.zzu.bbs.controller;
/*
 * User:程成
 * Date:2021/4/21
 * Time:15:01
 * Description:第一个SpringMvc类,该文件用于将请求的信息添加到model中, 返回给GetMapping对应的html模板页面
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
