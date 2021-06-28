package com.zyw.service.impl;

import com.zyw.entity.UserAddress;
import com.zyw.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * 1. 将服务提供者注册到注册中心（暴露服务）
 *    1). 导入dubbo依赖（写在pom.xml中）
 *    1). 配置服务提供者（新建spring配置文件provider.xml）
 * 2. 让服务消费者去注册中心订阅服务提供者的服务地址
 */
public class UserServiceImplMultiVersion implements UserService {

    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceImpl.....new.....");
        UserAddress address1 = new UserAddress(1, "安徽省合肥市瑶海区教师新村A区二栋106", "1"
                , "郑有为", "18940903056", "Y");
        UserAddress address2 = new UserAddress(2, "辽宁省大连市旅顺口区华发新城1栋1703", "1"
                , "郑亦心", "13615518484", "N");
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Arrays.asList(address1, address2);
    }
}
