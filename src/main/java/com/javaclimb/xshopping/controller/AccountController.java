package com.javaclimb.xshopping.controller;

import cn.hutool.core.util.StrUtil;
import com.javaclimb.xshopping.common.Common;
import com.javaclimb.xshopping.common.Result;
import com.javaclimb.xshopping.common.ResultCode;
import com.javaclimb.xshopping.entity.UserInfo;
import com.javaclimb.xshopping.exception.CustomException;
import com.javaclimb.xshopping.service.UserInfoService;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author Einstein
 * @version 1.0
 * @description Todo 登录退出相关的控制器
 * @date 2023/1/3 16:12
 * @see
 */
@RestController
public class AccountController {
    @Resource
    private UserInfoService userInfoService;

    /**
     * Todo 登录
     * @param userInfo
     * @param request
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody UserInfo userInfo, HttpServletRequest request){
        if(StrUtil.isBlank(userInfo.getName()) || StrUtil.isBlank(userInfo.getPassword())){
            //throw new RuntimeException();
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        /*从数据库查询账号密码是否正确，并放到 session*/
        UserInfo login = userInfoService.login(userInfo.getName(), userInfo.getPassword());
        HttpSession session = request.getSession();
        session.setAttribute(Common.USER_INFO, login);
        session.setMaxInactiveInterval(60 * 60 * 24);    //过期时间为：24h

        return Result.success(login);
    }

    /**
     * Todo 重置密码为：123456
     * @param userInfo
     * @return
     */
    @PostMapping("/resetPassword")
    public Result resetPassword(@RequestBody UserInfo userInfo){
        return Result.success(userInfoService.resetPassword(userInfo.getName()));
    }

    /**
     * Todo 登出
     * @param request
     * @return
     */
    @GetMapping("/logout")
    public Result logout(HttpServletRequest request){
        request.getSession().setAttribute(Common.USER_INFO, null);

        return Result.success();
    }

    /**
     * Todo 小程序端用户登录
     * * @param userInfo
     * @param request
     * * @return Result<UserInfo>
     **/
    @PostMapping("/register")
    public Result<UserInfo> register(@RequestBody UserInfo userInfo, HttpServletRequest request){
        if(StrUtil.isBlank(userInfo.getName()) || StrUtil.isBlank(userInfo.getPassword())){
            throw new CustomException(ResultCode.PARAM_ERROR);
        }
        UserInfo register = userInfoService.add(userInfo);
        HttpSession session = request.getSession();
        session.setAttribute(Common.USER_INFO, register);
        session.setMaxInactiveInterval(60 * 60 * 24);
        return Result.success(register);
    }

    /**
     * Todo 判断用户是否已登陆
     * * @param request
     * * @return Result
     **/
    @GetMapping("/auth")
    public Result getAuth(HttpServletRequest request){
        Object user = request.getSession().getAttribute(Common.USER_INFO);
        if(user == null){
            return Result.error("401", "未登录");
        }
        return Result.success(user);
    }
}
