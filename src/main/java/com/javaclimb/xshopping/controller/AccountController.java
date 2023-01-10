package com.javaclimb.xshopping.controller;

import cn.hutool.core.util.StrUtil;
import com.javaclimb.xshopping.common.Result;
import com.javaclimb.xshopping.common.ResultCode;
import com.javaclimb.xshopping.entity.UserInfo;
import com.javaclimb.xshopping.exception.CustomException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Einstein
 * @version 1.0
 * @description 登录退出相关的控制器
 * @date 2023/1/3 16:12
 * @see
 */
@RestController
public class AccountController {

    @PostMapping("/login")
    public Result login(@RequestBody UserInfo userInfo, HttpServletRequest request){
        if(StrUtil.isBlank(userInfo.getName()) || StrUtil.isBlank(userInfo.getPassword())){
            //throw new RuntimeException();
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        //todo 从数据库查询账号密码是否正确，放到 session
        return Result.success();
    }

}
