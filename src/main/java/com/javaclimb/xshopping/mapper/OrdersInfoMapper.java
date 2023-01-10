package com.javaclimb.xshopping.mapper;

import com.javaclimb.xshopping.entity.OrdersInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_info
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_info
     *
     * @mbg.generated
     */
    int insert(OrdersInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_info
     *
     * @mbg.generated
     */
    int insertSelective(OrdersInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_info
     *
     * @mbg.generated
     */
    OrdersInfo selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(OrdersInfo row);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table orders_info
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(OrdersInfo row);
}