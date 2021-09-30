package com.duan.order.wapper;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/23 6:17
 * @Description : spring-cloud-alibaba
 */
@FeignClient(value = "DUAN-GOODS", path = "/goods")
public interface GoodsWrapper {

    @GetMapping("/hello/{arg}")
    String hello(@PathVariable("arg") String arg);

    @RequestMapping("/evn")
    String evn();


    @RequestMapping("/sen/{arg}")
    String TestSentinel(@PathVariable("arg") Integer arg);

}
