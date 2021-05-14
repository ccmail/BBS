package com.zzu.bbs.service;
/*
 * User:程成
 * Date:2021/5/14
 * Time:22:30
 * Description:
 */

import com.zzu.bbs.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public void createOrUpdate(User user);
}
