package com.study.util;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * 返回消息结果类
 *
 * @author MoonMoonBird
 * @date 2022/7/24 16:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("返回结果类")
public class Result implements Serializable {

    /**
     * 状态码
     */
    @ApiModelProperty(value = "状态码")
    private Integer code;

    /**
     * 响应信息
     */
    @ApiModelProperty("响应信息")
    private String message;

    /**
     * 响应数据
     */
    @ApiModelProperty("响应数据")
    private Object data;

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * 响应成功
     *
     * @param message 响应信息
     * @param data    响应数据
     * @return 响应结果
     */
    public static Result success(String message, Object data) {
        return new Result(HttpStatus.OK.value(), message, data);
    }

    /**
     * 响应成功
     *
     * @param message 响应消息
     * @return 响应结果
     */
    public static Result success(String message) {
        return new Result(HttpStatus.OK.value(), message);
    }

    /**
     * 响应失败 用999表示失败
     *
     * @param message 响应消息
     * @return 响应结果
     */
    public static Result fail(String message) {
        return new Result(999, message);
    }

}
