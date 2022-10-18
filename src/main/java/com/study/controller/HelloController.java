package com.study.controller;

import com.alibaba.druid.support.json.JSONUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试接口", value = "测试接口")
@RestController
public class HelloController {

    @ApiOperation("运行测试")
    @GetMapping("/hello")
    public String hello() {
        return JSONUtils.toJSONString("hello spring");
    }
}
