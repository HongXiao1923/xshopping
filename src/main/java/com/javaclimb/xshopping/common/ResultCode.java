package com.javaclimb.xshopping.common;

/**
 * @author Einstein
 * @version 1.0
 * @description Todo 统一返回码（枚举类）
 * @date 2023/1/3 15:59
 */
public enum ResultCode {
    SUCCESS("0", "成功"),
    ERROR("-1", "系统异常"),
    PARAM_ERROR("1001", "参数异常"),
    USER_EXIST_ERROR("2001","用户已存在"),
    USER_ACCOUNT_ERROR("2002", "账户密码错误"),
    USER_NOT_EXIST_ERROR("2003","未找到用户");

    public String code;
    public String msg;

    ResultCode(String code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
