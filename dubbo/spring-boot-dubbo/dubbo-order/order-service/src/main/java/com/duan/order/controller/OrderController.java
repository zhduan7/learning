package com.duan.order.controller;

import com.duan.goods.DemoService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/27 19:23
 * @Description : spring-boot-dubbo
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @DubboReference(version = "1.0.0", check = false)
    private DemoService demoService;

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable("name") String name) {
        return demoService.sayHello(name);
    }


    @GetMapping("/haha")
    public String hah(String name) {
        return demoService.sayHello(name);
    }
}
