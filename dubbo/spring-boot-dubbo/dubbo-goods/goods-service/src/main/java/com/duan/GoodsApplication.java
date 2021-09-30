package com.duan;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/27 18:04
 * @Description : spring-boot-dubbo
 */
@SpringBootApplication
@EnableDubbo
public class GoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoodsApplication.class, args);
    }
}
