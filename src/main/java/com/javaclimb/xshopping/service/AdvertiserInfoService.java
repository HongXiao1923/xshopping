package com.javaclimb.xshopping.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.xshopping.entity.AdvertiserInfo;
import com.javaclimb.xshopping.mapper.AdvertiserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Einstein
 * @version 1.0
 * @description Todo 公告相关的service
 * @date 2023/1/12 5:57
 * @see
 */
@Service
public class AdvertiserInfoService {
    @Resource
    private AdvertiserInfoMapper advertiserInfoMapper;

    /**
     * 分页查询公告列表
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    public PageInfo<AdvertiserInfo> findPage(Integer pageNum, Integer pageSize, String name){
        PageHelper.startPage(pageNum, pageSize);
        List<AdvertiserInfo> list = advertiserInfoMapper.findByName(name);

        return PageInfo.of(list);
    }

    /**
     * 新增公告
     * @param advertiserInfo
     * @return
     */
    public AdvertiserInfo add(AdvertiserInfo advertiserInfo){
        advertiserInfo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        advertiserInfoMapper.insertSelective(advertiserInfo);

        return advertiserInfo;
    }

    /**
     * 修改公告
     * @param advertiserInfo
     */
    public void update(AdvertiserInfo advertiserInfo){
        advertiserInfo.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        advertiserInfoMapper.updateByPrimaryKeySelective(advertiserInfo);
    }

    /**
     * 根据 ID 删除公告
     * @param id
     */
    public void delete(Long id){
        advertiserInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据 ID 查询一条公告
     * @param id
     * @return
     */
    public AdvertiserInfo findById(Long id){
        return advertiserInfoMapper.selectByPrimaryKey(id);
    }
}
