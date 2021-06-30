package com.zyw.gmail;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


/**
 * 1. 导入依赖：
 *        1）：导入dubbo-starter
 *        2）：导入dubbo的其他依赖
 */
@EnableDubbo // 开启基于注解的dubbo配置
@EnableHystrix // 开启服务容错
@SpringBootApplication
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
