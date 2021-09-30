package com.duan.goods.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/20 0:29
 * @Description : com.duan.goods
 */
@RestController
@RequestMapping("/goods")
@RefreshScope
public class GoodsController {

    @Value("${server.port:0}")
    private String port;
    @Value("${evn:null}")
    private String evn;

    @GetMapping("/hello/{arg}")
    public String hello(@PathVariable("arg") String arg) {
        return "evn -> " + evn + ", port : " + port + ", msg : " + arg;
    }

    @GetMapping("/evn")
    public String evn() {
        return evn;
    }

    @SentinelResource(value = "hello", blockHandler = "exceptionHandler", fallback = "helloFallback")
    @GetMapping("/sen/{arg}")
    public String TestSentinel(@PathVariable("arg") Integer arg) {
        int a = 1000 / arg;
        return a + "Hello, Sentinel! port : " + port;
    }

    public String helloFallback(long s) {
        return String.format("Halooooo %d", s);
    }

    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public String exceptionHandler(long s, BlockException ex) {
        // Do some log here.
        ex.printStackTrace();
        return "Oops, error occurred at " + s;
    }
}
