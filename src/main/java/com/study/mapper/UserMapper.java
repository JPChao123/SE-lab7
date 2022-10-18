package com.study.mapper;

import com.study.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户持久层
 */
@Mapper
public interface UserMapper {

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    User login(@Param("username") String username, @Param("password") String password);


}
