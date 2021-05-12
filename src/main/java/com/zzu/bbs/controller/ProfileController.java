package com.zzu.bbs.controller;
/*
 * User:程成
 * Date:2021/5/12
 * Time:13:49
 * Description:个人中心页面的controller
 */

import com.github.pagehelper.PageInfo;
import com.zzu.bbs.dto.PostingDTO;
import com.zzu.bbs.model.User;
import com.zzu.bbs.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private PostingService postingService;

    @Value("${myPageHelper.config.pageSize}")
    private int pageSize;

    //    通过action动态控制跳转的地方
    @GetMapping("/profile/{action}")
    public String profile(@PathVariable(name = "action") String action,
                          Model model,
                          HttpServletRequest request,
                          @RequestParam(name = "page", defaultValue = "1") Integer pageStart) {


        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return "redirect:/";
        }


//        展示我的帖子 列表
        if ("postings".equals(action)) {
            model.addAttribute("section", "postings");
            model.addAttribute("sectionName", "我的帖子");
        } else if ("replies".equals(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }

        PageInfo<PostingDTO> pageInfo = postingService.getPageInfo(user.getId(), pageStart, pageSize);
        List<PostingDTO> postingDTOList = pageInfo.getList();
        model.addAttribute("postings", postingDTOList);
        model.addAttribute("pageInfo", pageInfo);
        return "profile";
    }
}
