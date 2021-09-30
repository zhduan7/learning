package com.duan.web;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author : zhduan
 * @version : 1.0
 * @date: 2021/9/17 11:28
 * @Description : com.duan.web
 */
@RestController
public class Client01TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @GetMapping("/client01")
    public String Test() {
//        InstanceInfo info = eurekaClient.getNextServerFromEureka("search01", false);
//        String url = info.getHomePageUrl();
//
//        String result = restTemplate.getForObject(url + "/search01", String.class);

        String result = restTemplate.getForObject("http://search01/search01", String.class);

        return "client01 --> " + result;
    }
}
