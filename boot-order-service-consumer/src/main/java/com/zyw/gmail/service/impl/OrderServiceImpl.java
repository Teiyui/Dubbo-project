package com.zyw.gmail.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zyw.entity.UserAddress;
import com.zyw.gmail.service.OrderService;
import com.zyw.service.UserService;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Reference(loadbalance = "roundrobin")
    private UserService userService;

    @HystrixCommand(fallbackMethod = "hello")
    public List<UserAddress> initOrder(String userId) {
        // 1. 查询用户的收货地址并返回
        System.out.println("用户id：" + userId);
        List<UserAddress> addressList = userService.getUserAddressList("1");
        return addressList;
    }

    /**
     * 服务容错机制下，出错的情况下调用的方法
     * @param userId
     * @return
     */
    public List<UserAddress> hello(String userId) {
        // 1. 查询用户的收货地址并返回
        System.out.println("出错情况下调用了该方法，用户id：" + userId);
        List<UserAddress> addressList = new ArrayList<>();
        addressList.add(new UserAddress(3, "安徽省合肥市瑶海区圣大国际4栋2404", "921755718"
                , "郑先哲", "15304046318", "N"));
        return addressList;
    }
}
