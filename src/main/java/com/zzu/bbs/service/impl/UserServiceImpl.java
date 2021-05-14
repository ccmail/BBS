package com.zzu.bbs.service.impl;
/*
 * User:程成
 * Date:2021/5/14
 * Time:22:31
 * Description:
 */

import com.zzu.bbs.mapper.UserMapper;
import com.zzu.bbs.model.User;
import com.zzu.bbs.model.UserExample;
import com.zzu.bbs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user.getAccountId());
        List<User> userDB = userMapper.selectByExample(userExample);
        if (userDB.size() == 0) {
            //数据库不存在该用户, 插入数据库
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModify(user.getGmtCreate());

            userMapper.insert(user);
        } else {
            //数据库中存在该用户, 更新token
            User user_temp = userDB.get(0);

            User updateUser = new User();
            updateUser.setGmtModify(System.currentTimeMillis());
            updateUser.setAvatarUrl(user.getAvatarUrl());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());

            UserExample example = new UserExample();
            example.createCriteria().andIdEqualTo(user_temp.getId());
            userMapper.updateByExampleSelective(updateUser, example);

        }
    }
}
