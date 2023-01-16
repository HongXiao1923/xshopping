package com.javaclimb.xshopping.service;

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
        goodsInfoMapper.insertSelective(goodsInfo);

        return goodsInfo;
    }

    /**
     * 修改商品
     * @param goodsInfo
     */
    public void update(GoodsInfo goodsInfo){
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
}
