package com.javaclimb.xshopping.exception;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.javaclimb.xshopping.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Einstein
 * @version 1.0
 * @description 控制器全局异常拦截
 * @date 2023/1/10 21:15
 * @see
 */
@ControllerAdvice(basePackages = "com.javaclimb.xshopping.controller")
public class GlobalExceptionHandler {

    public static final Log log = LogFactory.get();

    /**
     * 统一异常处理，主要用于Exception
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody   //返回JSON串
    public Result error(HttpServletRequest request, Exception e){
        log.error("异常信息", e);

        return Result.error();
    }

    /**
     * 用于专门处理 CustomException
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Result customError(HttpServletRequest request, CustomException e){
        //log.error("异常信息", e.getMsg());
        return Result.error(e.getCode(), e.getMsg());
    }
}
