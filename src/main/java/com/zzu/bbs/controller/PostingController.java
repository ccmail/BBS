package com.zzu.bbs.controller;
/*
 * User:程成
 * Date:2021/5/14
 * Time:18:27
 * Description: 帖子详情页面的管理器
 */

import com.zzu.bbs.dto.PostingDTO;
import com.zzu.bbs.service.PostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostingController {

    @Autowired
    private PostingService postingService;

    @GetMapping("posting/{id}")
    public String posting(@PathVariable(name = "id") Integer id,
                          Model model) {
        PostingDTO postingDTO = postingService.getById(id);
        model.addAttribute("posting",postingDTO);
        return "posting";
    }
}
