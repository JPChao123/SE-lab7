package com.study.controller;

import com.study.entity.User;
import com.study.service.UserService;
import com.study.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
@Api(value = "用户Controller类", tags = "用户相关接口")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    @ApiOperation("导入用户Model")
    public User user() {
        return null;
    }

    @PostMapping("/login")
    @ApiOperation("用户登录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", dataType = "string"),
            @ApiImplicitParam(name = "password", value = "密码", dataType = "string")
    })
    public Result login(@RequestBody Map<String, String> map) {
        return userService.login(map.get("username"), map.get("password"));
    }

}