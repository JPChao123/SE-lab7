package com.study;

import com.study.entity.User;
import com.study.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class LoginDemoApplicationTests {

    private final UserMapper userMapper;

    @Autowired
    LoginDemoApplicationTests(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Test
    void contextLoads() {
        User admin = userMapper.login("admin", "123");
        log.info("用户登录: {}", admin);
    }

}
