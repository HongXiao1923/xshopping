package com.javaclimb.xshopping.mapper;

import com.javaclimb.xshopping.entity.AdvertiserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 公告相关的 Mapper
 */
@Repository
public interface AdvertiserInfoMapper extends Mapper<AdvertiserInfo> {
    /*根据公告标题进行模糊查询*/
    List<AdvertiserInfo> findByName(@Param("name")String name);

}