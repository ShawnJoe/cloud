package com.zx.demo.common;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxu
 * @Description TODO
 * @date 2021/9/7-10:32 上午
 */

@Slf4j
@Data
public class Result <T>{

    private final static int SUCCESS_CODE = 200;
    private final static int ERROR_CODE = 500;

    private int code;

    private String msg;

    private T data;

    public Result(int code, String msg) {
        this(code, msg, null);
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> Result<T> success(T data) {
        return new Result<T>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> success(int code, T data) {
        return new Result<T>(code, ResultEnum.SUCCESS.getMsg(), data);
    }

    public static <T> Result<T> success(int code, String msg, T data) {
        return new Result<T>(code, msg, data);
    }

    public static <T> Result<T> success(int code, String msg) {
        return new Result<T>(code, msg);
    }

    public static <T> Result<T> error(String msg) {
        return new Result<>(ResultEnum.ERROR.getCode(), msg);
    }

    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, msg);
    }

    public static <T> Result<T> error(int code, String msg, T data) {
        return new Result<>(code, msg, data);
    }

}
