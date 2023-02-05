package com.javaclimb.xshopping.controller;

import com.github.pagehelper.PageInfo;
import com.javaclimb.xshopping.common.Result;
import com.javaclimb.xshopping.entity.GoodsInfo;
import com.javaclimb.xshopping.service.GoodsInfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Einstein
 * @version 1.0
 * @description Todo 商品增删改查控制器
 * @date 2023/1/14 7:03
 * @see
 */
@RestController
@RequestMapping(value = "/goodsInfo")
public class GoodsInfoController {
    @Resource
    private GoodsInfoService goodsInfoService;

    /**
     * 分页查询商品列表
     * @param pageNum 第几页
     * @param pageSize 每页大小
     * @param name 商品名称
     * @return
     */
    @GetMapping("/page/{name}")
    public Result<PageInfo<GoodsInfo>> page(@RequestParam(defaultValue = "1") Integer pageNum,
                                           @RequestParam(defaultValue = "10") Integer pageSize,
                                           @PathVariable String name){
        return Result.success(goodsInfoService.findPage(pageNum, pageSize, name));
    }

    /**
     * 新增商品
     * @param goodsInfo
     * @return
     */
    @PostMapping
    public Result<GoodsInfo> add(@RequestBody GoodsInfo goodsInfo){
        goodsInfoService.add(goodsInfo);

        return Result.success(goodsInfo);
    }

    /**
     * 更新商品
     * @param goodsInfo
     * @return
     */
    @PutMapping
    public Result update(@RequestBody GoodsInfo goodsInfo){
        goodsInfoService.update(goodsInfo);

        return Result.success();
    }

    /**
     * 删除商品
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        goodsInfoService.delete(id);

        return Result.success();
    }

    /**
     * 根据 ID 查询一条商品
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result detail(@PathVariable Long id){

        return Result.success(goodsInfoService.findById(id));
    }

    /**
     * 分页查询推荐商品
     * @param pageNum 第几页
     * @param pageSize 每页大小
     * @return
     */
    @GetMapping("/findRecommendGoods")
    public Result<PageInfo<GoodsInfo>> findRecommendGoods(@RequestParam(defaultValue = "1") Integer pageNum,
                                            @RequestParam(defaultValue = "100") Integer pageSize){
        return Result.success(goodsInfoService.findRecommendGoods(pageNum, pageSize));
    }

    /**
     * 分页查询热卖商品
     * @param pageNum 第几页
     * @param pageSize 每页大小
     * @return
     */
    @GetMapping("/findHotSalesGoods")
    public Result<PageInfo<GoodsInfo>> findHotSalesGoods(@RequestParam(defaultValue = "1") Integer pageNum,
                                                          @RequestParam(defaultValue = "10") Integer pageSize){
        return Result.success(goodsInfoService.findHotSalesGoods(pageNum, pageSize));
    }
}
