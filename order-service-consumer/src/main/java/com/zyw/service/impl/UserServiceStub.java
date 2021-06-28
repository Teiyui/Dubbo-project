package com.zyw.service.impl;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.zyw.entity.UserAddress;
import com.zyw.service.UserService;

import java.util.List;

public class UserServiceStub implements UserService {

    private UserService userService;

    /**
     * 传入的是userService远程的代理对象
     * @param userService
     * @return
     */
    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceStub.....");
        if (StringUtils.isNotEmpty(userId)) {
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
