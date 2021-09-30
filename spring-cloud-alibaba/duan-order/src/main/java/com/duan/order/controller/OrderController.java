package com.duan.order.controller;

import com.duan.order.wapper.GoodsWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/20 0:40
 * @Description : com.duan.order.controller
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private GoodsWrapper goodsWrapper;

    @GetMapping("/hi")
    public String hi(String arg) {

        String result = goodsWrapper.hello(arg);
        return "order --> goods: " + result;
    }

    @GetMapping("/evn")
    public String evn() {
        return goodsWrapper.evn();
    }

    @GetMapping("/see/{arg}")
    public String see(@PathVariable("arg") Integer arg) {

        String result = goodsWrapper.TestSentinel(arg);
        return String.format("order  --> goods: %s", result);
    }
}
