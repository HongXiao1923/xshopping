package com.javaclimb.xshopping.exception;

import com.javaclimb.xshopping.common.ResultCode;

/**
 * @author Einstein
 * @version 1.0
 * @description Todo 用户自定义异常，用于前端返回错误信息
 * @date 2023/1/10 21:04
 * @see
 */
public class CustomException extends RuntimeException {
    private String code;
    private String msg;

    public CustomException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CustomException(ResultCode resultCode) {
        this.code = resultCode.code;
        this.msg = resultCode.msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
