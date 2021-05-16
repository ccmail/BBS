package com.zzu.bbs.service.impl;
/*
 * User:程成
 * Date:2021/5/16
 * Time:23:02
 * Description:
 */

import com.zzu.bbs.exception.CustomErrorCode;
import com.zzu.bbs.exception.CustomException;
import com.zzu.bbs.mapper.CommentMapper;
import com.zzu.bbs.model.Comment;
import com.zzu.bbs.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void insert(Comment comment) {
        if (comment.getParentId() == null || comment.getParentId() == 0) {

throw new CustomException(CustomErrorCode.TARGET_PARAM_NOT_FOUND);

        }
    }
}
