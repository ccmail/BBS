package com.zzu.bbs.controller;
/*
 * User:程成
 * Date:2021/4/21
 * Time:15:01
 * Description:第一个SpringMvc类,该文件用于将请求的信息添加到model中, 返回给GetMapping对应的html模板页面
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzu.bbs.dto.PostingDTO;
import com.zzu.bbs.mapper.UserMapper;
import com.zzu.bbs.model.User;
import com.zzu.bbs.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PostingService postingService;

    @Value("${myPageHelper.config.startPage}")
    private int pageStart;

    @Value("${myPageHelper.config.pageSize}")
    private int pageSize;



    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page",defaultValue = "1")Integer page,
                        @RequestParam(name = "page",defaultValue = "10")Integer size) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    String token_value = cookie.getValue();
                    User user = userMapper.findByToken(token_value);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }

                    break;
                }
            }
        }

//用cookies检查登陆状态, 在return前进行数据查询, 获取列表信息
        PageInfo<PostingDTO> pageInfo = postingService.getPageInfo(page, pageSize);
        List<PostingDTO> postingList = pageInfo.getList();
        model.addAttribute("postings",postingList);
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }
}
