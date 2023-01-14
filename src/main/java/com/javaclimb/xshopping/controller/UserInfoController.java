package com.javaclimb.xshopping.controller;

import com.github.pagehelper.PageInfo;
import com.javaclimb.xshopping.common.Result;
import com.javaclimb.xshopping.entity.UserInfo;
import com.javaclimb.xshopping.service.UserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Einstein
 * @version 1.0
 * @description 用户增删改查控制器
 * @date 2023/1/14 7:03
 * @see
 */
@RestController
@RequestMapping(value = "/userInfo")
public class UserInfoController {
    @Resource
    private UserInfoService userInfoService;

    /**
     * 分页查询用户列表
     * @param pageNum 第几页
     * @param pageSize 每页大小
     * @param name 用户名
     * @return
     */
    @GetMapping("/page/{name}")
    public Result<PageInfo<UserInfo>> page(@RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                           @PathVariable String name){
        return Result.success(userInfoService.findPage(pageNum, pageSize, name));
    }

    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    @PostMapping
    public Result<UserInfo> add(@RequestBody UserInfo userInfo){
        userInfoService.add(userInfo);

        return Result.success(userInfo);
    }
}
