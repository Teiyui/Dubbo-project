package com.zyw.gmail.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zyw.entity.UserAddress;
import com.zyw.gmail.service.OrderService;
import com.zyw.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference(url = "127.0.0.1:20990") // dubbo直连
    private UserService userService;

    public List<UserAddress> initOrder(String userId) {
        // 1. 查询用户的收货地址并返回
        System.out.println("用户id：" + userId);
        List<UserAddress> addressList = userService.getUserAddressList("1");
        return addressList;
    }
}
