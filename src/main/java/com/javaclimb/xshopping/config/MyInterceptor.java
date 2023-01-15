package com.javaclimb.xshopping.config;

import com.javaclimb.xshopping.common.Common;
import com.javaclimb.xshopping.entity.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Einstein
 * @version 1.0
 * @description Todo 全局设置拦截器（如果没有登录，重定向到登录页）
 * @date 2023/1/16 0:17
 * @see
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * 所有访问后台的请求，先要从这里路过
     * @param request
     * @param response
     * @param handler
     * @return Todo 返回true就继续执行后面的请求，返回false就中断后面的请求，直接转向登录页
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute(Common.USER_INFO);
        if(userInfo == null){
            //若为空信息需要重定向到登录页
            response.sendRedirect("/end/page/login.html");
            return false;
        }

        return true;
    }
}
