package com.javaclimb.xshopping.service;

import cn.hutool.core.collection.CollectionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.xshopping.entity.GoodsInfo;
import com.javaclimb.xshopping.mapper.GoodsInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Einstein
 * @version 1.0
 * @description Todo 商品相关的service
 * @date 2023/1/12 5:57
 * @see
 */
@Service
public class GoodsInfoService {
    @Resource
    private GoodsInfoMapper goodsInfoMapper;

    /**
     * 分页查询商品列表
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    public PageInfo<GoodsInfo> findPage(Integer pageNum, Integer pageSize, String name){
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsInfo> list = goodsInfoMapper.findByName(name, null);

        return PageInfo.of(list);
    }

    /**
     * 新增商品
     * @param goodsInfo
     * @return
     */
    public GoodsInfo add(GoodsInfo goodsInfo){
        convertFileListToFields(goodsInfo);
        goodsInfoMapper.insertSelective(goodsInfo);

        return goodsInfo;
    }

    /**
     * 修改商品
     * @param goodsInfo
     */
    public void update(GoodsInfo goodsInfo){
        convertFileListToFields(goodsInfo);
        goodsInfoMapper.updateByPrimaryKeySelective(goodsInfo);
    }

    /**
     * 根据 ID 删除商品
     * @param id
     */
    public void delete(Long id){
        goodsInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id获取商品
     * @param id
     * @return
     */
    public GoodsInfo findById(Long id){
        List<GoodsInfo> list = goodsInfoMapper.findByName(null, id);
        if(list == null || list.size() == 0){
            return null;
        }
        return list.get(0);
    }

    /**
     * 将页面传来的文件列表转换成以逗号隔开的id列表
     * @param goodsInfo
     */
    private void convertFileListToFields(GoodsInfo goodsInfo){
        List<Long> fileList = goodsInfo.getFileList();
        if(!CollectionUtil.isEmpty(fileList)){
            goodsInfo.setFields(fileList.toString());
        }
    }

    /**
     * 查询推荐商品
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<GoodsInfo> findRecommendGoods(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsInfo> list = goodsInfoMapper.findRecommendGoods();

        return PageInfo.of(list);
    }

    /**
     * 查询热门商品
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageInfo<GoodsInfo> findHotSalesGoods(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<GoodsInfo> list = goodsInfoMapper.findHotSalesGoods();

        return PageInfo.of(list);
    }

}
