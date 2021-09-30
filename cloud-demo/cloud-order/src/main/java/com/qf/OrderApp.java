package com.qf;

import com.rule.MyRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>title: com.qf</p>
 * <p>Company: wendao</p>
 * author zhuximing
 * date 2021/8/16
 * description:
 */
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "cloud-goods",configuration = {MyRule.class})
@EnableFeignClients(basePackages = {"com.api"})  //开启openfeign
@MapperScan(basePackages = {"com.qf.mapper"})
public class OrderApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }

//
//    @Bean
//    @LoadBalanced
//    public RestTemplate  initRestTemplate(){
//
//        return  new RestTemplate();
//    }

}