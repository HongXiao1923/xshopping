package com.javaclimb.xshopping.mapper;

import com.javaclimb.xshopping.entity.GoodsInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 商品相关的 Mapper
 */
@Repository
public interface GoodsInfoMapper extends Mapper<GoodsInfo> {
    /*根据商品名称模糊查询，或者根据id查询一个商品*/
    List<GoodsInfo> findByName(@Param("name")String name, @Param("id") Long id);

    /*推荐商品（简单查询可以不用写到.xml中）*/
    @Select("select * from goods_info where recommend = '是'")
    List<GoodsInfo> findRecommendGoods();

    /*热卖商品（简单查询可以不用写到.xml中）*/
    @Select("select * from goods_info order by sales desc")
    List<GoodsInfo> findHotSalesGoods();
}