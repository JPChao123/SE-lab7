package com.study.service;

import com.study.entity.User;
import com.study.util.Result;

public interface UserService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    Result login(String username, String password);

}
