package com.javaclimb.xshopping.common;

/**
 * @author Einstein
 * @version 1.0
 * @description Todo 统一返回前端结果类
 * @date 2023/1/3 15:54
 * @see
 */
public class Result<T> {
    /*返回码*/
    private String code;
    /*返回中文信息*/
    private String msg;
    /*返回的对象类*/
    private T data;

    /**
     * Todo 不带参数的成功返回
     * @return
     */
    public static Result success(){
        Result result = new Result<>();
        result.setCode(ResultCode.SUCCESS.code);
        result.setMsg(ResultCode.SUCCESS.msg);

        return result;
    }

    /**
     * Todo 带参数的成功返回
     * @return
     */
    public static <T> Result<T> success(T data){
        Result result = new Result<T>(data);
        result.setCode(ResultCode.SUCCESS.code);
        result.setMsg(ResultCode.SUCCESS.msg);

        return result;
    }

    /**
     * Todo 不带参数的失败返回（错误类型自定义）
     * @return
     */
    public static Result error(){
        Result result = new Result<>();
        result.setCode(ResultCode.ERROR.code);
        result.setMsg(ResultCode.ERROR.msg);

        return result;
    }

    /**
     * Todo 带错误提示的失败返回（错误类型自定义）
     * @return
     */
    public static Result error(String code, String msg){
        Result result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }

    public Result() {
    }

    public Result(T data) {
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
