package com.zyw.service.impl;

import com.zyw.entity.UserAddress;
import com.zyw.service.OrderService;
import com.zyw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private UserService userService;

    public void initOrder(String userId) {
        // 1. 查询用户的收货地址
        System.out.println("用户id：" + userId);
        List<UserAddress> addressList = userService.getUserAddressList("1");
        for (UserAddress address : addressList) {
            System.out.println(address);
        }
    }
}
