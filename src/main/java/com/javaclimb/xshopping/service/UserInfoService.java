package com.javaclimb.xshopping.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.javaclimb.xshopping.common.ResultCode;
import com.javaclimb.xshopping.entity.UserInfo;
import com.javaclimb.xshopping.exception.CustomException;
import com.javaclimb.xshopping.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * @author Einstein
 * @version 1.0
 * @description Todo 用户相关的service
 * @date 2023/1/12 5:57
 * @see
 */
@Service
public class UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * Todo 登录
     * @param name
     * @param password
     * @return
     */
    public UserInfo login(String name, String password){
        /*判断数据库中是否有该用户*/
        List<UserInfo> list = userInfoMapper.findByName(name);
        if(CollectionUtil.isEmpty(list)){
            throw new CustomException(ResultCode.USER_NOT_EXIST_ERROR);
        }
        /*判断密码是否正确*/
        if(!SecureUtil.md5(password).equals(list.get(0).getPassword())){
            throw new CustomException(ResultCode.USER_ACCOUNT_ERROR);
        }
        return list.get(0);
    }

    /**
     * Todo 重置密码（忘记密码时的暴力处理方法）
     * @param name
     * @return
     */
    public UserInfo resetPassword(String name){
        /*判断数据库中是否有该用户*/
        List<UserInfo> list = userInfoMapper.findByName(name);
        if(CollectionUtil.isEmpty(list)){
            throw new CustomException(ResultCode.USER_NOT_EXIST_ERROR);
        }
        list.get(0).setPassword(SecureUtil.md5("123456"));
        userInfoMapper.updateByPrimaryKeySelective(list.get(0));

        return list.get(0);
    }

    /**
     * Todo 分页查询用户列表
     * @param pageNum
     * @param pageSize
     * @param name
     * @return
     */
    public PageInfo<UserInfo> findPage(Integer pageNum, Integer pageSize, String name){
        PageHelper.startPage(pageNum, pageSize);
        List<UserInfo> list = userInfoMapper.findByName(name);

        return PageInfo.of(list);
    }

    /**
     * Todo 新增用户
     * @param userInfo
     * @return
     */
    public UserInfo add(UserInfo userInfo){
        //判断用户是否已存在
        int count = userInfoMapper.checkRepeat("name", userInfo.getName());
        if(count > 0){
            throw new CustomException(ResultCode.USER_EXIST_ERROR);
        }
        //验证密码
        if(StrUtil.isBlank(userInfo.getPassword())){
            //默认密码123456
            userInfo.setPassword(SecureUtil.md5("123456"));
        }else{
            userInfo.setPassword(SecureUtil.md5(userInfo.getPassword()));
        }
        //设置新增用户是买家
        userInfo.setLevel(3);
        userInfoMapper.insertSelective(userInfo);

        return userInfo;
    }

    /**
     * Todo 修改用户
     * @param userInfo
     */
    public void update(UserInfo userInfo){
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    /**
     * Todo 根据 ID 删除用户
     * @param id
     */
    public void delete(Long id){
        userInfoMapper.deleteByPrimaryKey(id);
    }
}
