package com.zzu.bbs.controller;
/*
 * User:程成
 * Date:2021/4/28
 * Time:10:28
 * Description:发帖页面的controller, 用get和post格式区分,get请求用于渲染页面,post请求用于提交表单进行跳转
 */

import com.zzu.bbs.mapper.PostingMapper;
import com.zzu.bbs.mapper.UserMapper;
import com.zzu.bbs.model.Posting;
import com.zzu.bbs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    //    自动将前端传回的参数注入到实体变量中
    @Autowired
    private PostingMapper postingMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    //    接受前端页面返回的参数
    @PostMapping("/publish")
    public String doPublish(
            @RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("tag") String tag,
            HttpServletRequest request,
            Model model
    ) {
        model.addAttribute("title", title);
        model.addAttribute("description", description);
        model.addAttribute("tag", tag);


        if (title == null || title.equals("")) {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        } else if (description == null || description.equals("")) {
            model.addAttribute("error", "内容不能为空");
            return "publish";
        } else if (tag == null || tag.equals("")) {
            model.addAttribute("error", "开发期间tag不要为空");
            return "publish";
        }


        Posting posting = new Posting();
        posting.setTitle(title);
        posting.setDescription(description);
        posting.setTag(tag);
        posting.setGmt_create(System.currentTimeMillis());
        posting.setGmt_modify(posting.getGmt_create());


//        开始添加用户id
        User user = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token_value = cookie.getValue();
                    user = userMapper.findByToken(token_value);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }

                    break;
                }
            }
            if (user == null) {
                model.addAttribute("error", "用户未登录");
                System.out.println("==============用户未登录====================");
                return "publish";
            } else {
                posting.setCreator(user.getId());
                postingMapper.create(posting);
                return "redirect:/";


            }

        } else {
            model.addAttribute("error", "未获取到cookie信息");
            System.out.println("=================没有获取到cookie信息=======================");
            return "publish";

        }


    }
}
