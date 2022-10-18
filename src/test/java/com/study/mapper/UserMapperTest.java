package com.study.mapper;

import com.study.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserMapperTest {

    private final UserMapper userMapper;

    @Autowired
    UserMapperTest(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Test
    void login() {
        User admin = userMapper.login("admin", "123");
        System.out.println(admin.toString());
    }
}