package com.duan.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/17 11:25
 * @Description : com.duan.web
 */
@RestController
public class Search01TestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/search01")
    public String Test() {

        return "Hello Spring Cloud! port : " + port;
    }
}
