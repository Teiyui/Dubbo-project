package com.zyw.bootserviceproviderlogconfig.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.zyw.entity.UserAddress;
import com.zyw.service.UserService;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author: ywzheng
 * @Description: TODO
 * @date: 2021/11/4 3:50 PM
 */
@Service(interfaceClass = UserService.class, dynamic = true)
@Component
public class UserServiceImpl {

    @HystrixCommand
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("这是第一台服务器");
        UserAddress address1 = new UserAddress(1, "安徽省合肥市瑶海区教师新村A区二栋106", "1"
                , "郑有为", "18940903056", "Y");
        UserAddress address2 = new UserAddress(2, "辽宁省大连市旅顺口区华发新城1栋1703", "1"
                , "郑亦心", "13615518484", "N");
        // 设置随机异常，用于验证服务容错机制
        if (Math.random() > 0.5) {
            throw new RuntimeException("");
        }

        return Arrays.asList(address1, address2);
    }
}
