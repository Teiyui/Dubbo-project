package com.zyw.gmail.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.zyw.entity.UserAddress;

import java.util.List;

@Service
public interface OrderService {

    /**
     * 初始化订单
     * @param userId
     */
    public List<UserAddress> initOrder(String userId);
}
