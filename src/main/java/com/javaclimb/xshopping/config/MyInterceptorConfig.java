package com.javaclimb.xshopping.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Einstein
 * @version 1.0
 * @description Todo 全局拦截配置，随着SpringBoot的启动就会加载
 * @date 2023/1/16 0:27
 * @see
 */
@Configuration
public class MyInterceptorConfig implements WebMvcConfigurer {
    /**
     * Todo 登录页本身不能被拦截，静态资源也不能被拦截
     * Todo 实现 WebMvcConfigurer 不会导致静态资源被拦截
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new MyInterceptor()).addPathPatterns("/end/page/**")
                .excludePathPatterns("/end/page/login.html");
    }
}
