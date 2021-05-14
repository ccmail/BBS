package com.zzu.bbs.service.impl;
/*
 * User:程成
 * Date:2021/5/14
 * Time:22:31
 * Description:
 */

import com.zzu.bbs.mapper.UserMapper;
import com.zzu.bbs.model.User;
import com.zzu.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void createOrUpdate(User user) {
        User userDB = userMapper.findByAccountId(user.getAccount_id());
        if (userDB==null){
            //数据库不存在该用户, 插入数据库
            user.setGmt_create(System.currentTimeMillis());
            user.setGmt_modify(user.getGmt_create());

            userMapper.insert(user);
        }else  {
            //数据库中存在该用户, 更新token
            userDB.setGmt_modify(System.currentTimeMillis());
            userDB.setAvatar_url(user.getAvatar_url());
            userDB.setName(user.getName());
            userDB.setToken(user.getToken());
            userMapper.update(userDB);

        }
    }
}
