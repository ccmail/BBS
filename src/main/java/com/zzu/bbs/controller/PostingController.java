package com.zzu.bbs.controller;
/*
 * User:程成
 * Date:2021/5/14
 * Time:18:27
 * Description: 帖子详情页面的管理器
 */

import com.zzu.bbs.dto.PostingDTO;
import com.zzu.bbs.exception.CustomErrorCode;
import com.zzu.bbs.exception.CustomException;
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
    public String posting(@PathVariable(name = "id") String id,
                          Model model) {
        Long postingId = null;
        try {
            postingId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            throw new CustomException(CustomErrorCode.INVALID_INPUT);
        }

        PostingDTO postingDTO = postingService.getById(postingId);
        postingService.addViewCount(postingId);
        model.addAttribute("posting", postingDTO);
        return "posting";
    }
}
