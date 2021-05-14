package com.zzu.bbs.controller;
/*
 * User:程成
 * Date:2021/4/28
 * Time:10:28
 * Description:发帖页面的controller, 用get和post格式区分,get请求用于渲染页面,post请求用于提交表单进行跳转
 */

import com.zzu.bbs.dto.PostingDTO;
import com.zzu.bbs.mapper.PostingMapper;
import com.zzu.bbs.model.Posting;
import com.zzu.bbs.model.User;
import com.zzu.bbs.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class PublishController {

    //    自动将前端传回的参数注入到实体变量中
    @Autowired
    private PostingMapper postingMapper;

    @Autowired
    private PostingService postingService;

    @GetMapping("/publish")
    public String publish() {
        return "publish";
    }

    @GetMapping("/publish/{id}")
    public String edit(@PathVariable(name = "id") Integer id,
                       Model model) {
        PostingDTO posting = postingService.getById(id);
        model.addAttribute("title", posting.getTitle());
        model.addAttribute("description", posting.getDescription());
        model.addAttribute("tag", posting.getTag());
        model.addAttribute("id",posting.getId());
        return "publish";
    }

    //    接受前端页面返回的参数
    @PostMapping("/publish")
    public String doPublish(
            @RequestParam(value = "title",required = false) String title,
            @RequestParam(value = "description",required = false) String description,
            @RequestParam(value = "tag",required = false) String tag,
            @RequestParam(value = "id",required = false) Integer id,
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


//        开始添加用户id
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "用户未登录");
            return "publish";
        }


        Posting posting = new Posting();
        posting.setTitle(title);
        posting.setDescription(description);
        posting.setTag(tag);

        posting.setCreator(user.getId());
        posting.setId(id);

        postingService.createOrUpdate(posting);
        return "redirect:/";
    }
}
