package com.zzu.bbs.service;
/*
 * User:程成
 * Date:2021/5/16
 * Time:23:01
 * Description:
 */

import com.zzu.bbs.model.Comment;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    public void insert(Comment comment) ;
}
