package com.javaclimb.xshopping.service;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.crypto.SecureUtil;
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
 * @description 用户相关的service
 * @date 2023/1/12 5:57
 * @see
 */
@Service
public class UserInfoService {
    @Resource
    private UserInfoMapper userInfoMapper;

    /**
     * 登录
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
     * 重置密码（忘记密码时的暴力处理方法）
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
}
