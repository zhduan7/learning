package com.duan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/17 11:18
 * @Description : com.duan
 */
@SpringBootApplication
@EnableEurekaClient
public class SearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
    }
}
