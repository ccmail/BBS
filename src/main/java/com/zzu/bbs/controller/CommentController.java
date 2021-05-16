package com.zzu.bbs.controller;
/*
 * User:程成
 * Date:2021/5/16
 * Time:22:13
 * Description:
 */


import com.zzu.bbs.dto.CommentDTO;
import com.zzu.bbs.dto.ResultDTO;
import com.zzu.bbs.exception.CustomErrorCode;
import com.zzu.bbs.mapper.CommentMapper;
import com.zzu.bbs.model.Comment;
import com.zzu.bbs.model.User;
import com.zzu.bbs.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @ResponseBody
    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public Object post(@RequestBody CommentDTO commentDTO,
                       HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            return ResultDTO.errorOf(CustomErrorCode.NO_LOGIN.getCode(), CustomErrorCode.NO_LOGIN.getMessage());
        }


        Comment comment = new Comment();
        comment.setParentId(commentDTO.getParentId());
        comment.setContent(commentDTO.getContent());
        comment.setType(commentDTO.getType());
        comment.setGmtModify(System.currentTimeMillis());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setDislikeCount(0L);
        comment.setLikeCount(0L);
        comment.setCommentator(user.getId());

        commentService.insert(comment);

        HashMap<Object, Object> objectHashMap = new HashMap<>();
        objectHashMap.put("message", "成功");
        return objectHashMap;
    }

}
