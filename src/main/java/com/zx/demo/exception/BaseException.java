package com.zx.demo.exception;

import com.zx.demo.common.ResultEnum;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxu
 * @Description TODO
 * @date 2021/9/7-10:12 上午
 */

@Slf4j
@Data
public class BaseException extends RuntimeException {
    private int code;
    private String msg;

    public BaseException() {
        this(ResultEnum.ERROR);
    }

    public BaseException(ResultEnum failed) {
        this.code = failed.getCode();
        this.msg = failed.getMsg();
    }
    public BaseException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
