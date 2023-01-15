package com.javaclimb.xshopping.controller;

import com.github.pagehelper.PageInfo;
import com.javaclimb.xshopping.common.Result;
import com.javaclimb.xshopping.entity.AdvertiserInfo;
import com.javaclimb.xshopping.service.AdvertiserInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Einstein
 * @version 1.0
 * @description 公告增删改查控制器
 * @date 2023/1/14 7:03
 * @see
 */
@RestController
@RequestMapping(value = "/advertiserInfo")
public class AdvertiserInfoController {
    @Resource
    private AdvertiserInfoService advertiserInfoService;

    /**
     * 分页查询公告列表
     * @param pageNum 第几页
     * @param pageSize 每页大小
     * @param name 公告名
     * @return
     */
    @GetMapping("/page/{name}")
    public Result<PageInfo<AdvertiserInfo>> page(@RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                           @PathVariable String name){
        return Result.success(advertiserInfoService.findPage(pageNum, pageSize, name));
    }

    /**
     * 新增公告
     * @param advertiserInfo
     * @return
     */
    @PostMapping
    public Result<AdvertiserInfo> add(@RequestBody AdvertiserInfo advertiserInfo){
        advertiserInfoService.add(advertiserInfo);

        return Result.success(advertiserInfo);
    }

    /**
     * 更新公告
     * @param advertiserInfo
     * @return
     */
    @PutMapping
    public Result update(@RequestBody AdvertiserInfo advertiserInfo){
        advertiserInfoService.update(advertiserInfo);

        return Result.success();
    }

    /**
     * 删除公告
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        advertiserInfoService.delete(id);

        return Result.success();
    }

    /**
     * 根据 ID 查询一条公告
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id){

        return Result.success(advertiserInfoService.findById(id));
    }
}
