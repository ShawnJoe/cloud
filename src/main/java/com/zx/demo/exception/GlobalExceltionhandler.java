package com.zx.demo.exception;

import com.zx.demo.common.Result;
import com.zx.demo.common.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxu
 * @Description 全局异常处理
 * @date 2021/9/7-1:34 下午
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceltionhandler {

    /**
     * 自定义异常APIException
     */
    @ExceptionHandler(BaseException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Result<Object> APIExceptionHandler(BaseException e) {
        log.error("api异常");
        return  Result.error(e.getCode(), e.getMsg());
    }
    /**
     * 方法参数错误异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Result<Object> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error("方法参数错误异常");
        List<String> list=new ArrayList<>();        // 从异常对象中拿到ObjectError对象
        if (!e.getBindingResult().getAllErrors().isEmpty()){
            for(ObjectError error:e.getBindingResult().getAllErrors()){
                list.add(error.getDefaultMessage().toString());
            }
        }
        // 然后提取错误提示信息进行返回
        return Result.error(ResultEnum.VALIDATE_FAILED.getCode(), ResultEnum.VALIDATE_FAILED.getMsg(), list);
    }
}
