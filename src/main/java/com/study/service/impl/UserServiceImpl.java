package com.study.service.impl;

import com.study.entity.User;
import com.study.mapper.UserMapper;
import com.study.service.UserService;
import com.study.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Result login(String username, String password) {
        User user = userMapper.login(username, password);
        if (ObjectUtils.isEmpty(user)) {
            return Result.fail("用户名或密码错误");
        }
        return Result.success("登录成功", user);
    }

}
