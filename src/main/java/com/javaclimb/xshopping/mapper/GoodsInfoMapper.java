package com.javaclimb.xshopping.mapper;

import com.javaclimb.xshopping.entity.GoodsInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_info
     *
     * @mbg.generated
     */
    int insert(GoodsInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_info
     *
     * @mbg.generated
     */
    int insertSelective(GoodsInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_info
     *
     * @mbg.generated
     */
    GoodsInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(GoodsInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(GoodsInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(GoodsInfo row);
}