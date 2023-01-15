package com.javaclimb.xshopping.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.xshopping.entity.TypeInfo;
import com.javaclimb.xshopping.mapper.TypeInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Einstein
 * @version 1.0
 * @description Todo 商品类别相关的service
 * @date 2023/1/12 5:57
 * @see
 */
@Service
public class TypeInfoService {
    @Resource
    private TypeInfoMapper typeInfoMapper;

    /**
     * 分页查询商品类别列表
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    public PageInfo<TypeInfo> findPage(Integer pageNum, Integer pageSize, String name){
        PageHelper.startPage(pageNum, pageSize);
        List<TypeInfo> list = typeInfoMapper.findByName(name);

        return PageInfo.of(list);
    }

    /**
     * 新增商品类别
     * @param typeInfo
     * @return
     */
    public TypeInfo add(TypeInfo typeInfo){
        typeInfoMapper.insertSelective(typeInfo);

        return typeInfo;
    }

    /**
     * 修改商品类别
     * @param typeInfo
     */
    public void update(TypeInfo typeInfo){
        typeInfoMapper.updateByPrimaryKeySelective(typeInfo);
    }

    /**
     * 根据 ID 删除商品类别
     * @param id
     */
    public void delete(Long id){
        typeInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id获取商品类别
     * @param id
     * @return
     */
    public TypeInfo findById(Long id){
        return typeInfoMapper.selectByPrimaryKey(id);
    }
}
