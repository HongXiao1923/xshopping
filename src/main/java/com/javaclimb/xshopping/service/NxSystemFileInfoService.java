package com.javaclimb.xshopping.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.xshopping.entity.NxSystemFileInfo;
import com.javaclimb.xshopping.mapper.NxSystemFileInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Einstein
 * @version 1.0
 * @description Todo 系统文件相关的service
 * @date 2023/1/12 5:57
 * @see
 */
@Service
public class NxSystemFileInfoService {
    @Resource
    private NxSystemFileInfoMapper nxSystemFileInfoMapper;

    /*分页查询系统-不再需要*/

    /**
     * 新增系统文件
     * @param nxSystemFileInfo
     * @return
     */
    public NxSystemFileInfo add(NxSystemFileInfo nxSystemFileInfo){
        nxSystemFileInfoMapper.insertSelective(nxSystemFileInfo);

        return nxSystemFileInfo;
    }

    /**
     * 修改系统文件
     * @param nxSystemFileInfo
     */
    public void update(NxSystemFileInfo nxSystemFileInfo){
        nxSystemFileInfoMapper.updateByPrimaryKeySelective(nxSystemFileInfo);
    }

    /**
     * 根据 ID 删除系统文件
     * @param id
     */
    public void delete(Long id){
        nxSystemFileInfoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据id获取系统文件
     * @param id
     * @return
     */
    public NxSystemFileInfo findById(Long id){
        return nxSystemFileInfoMapper.selectByPrimaryKey(id);
    }
}
