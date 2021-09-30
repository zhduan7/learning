package com.qf.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

@Component
public class CustomerRequestInterceptor implements RequestInterceptor {


    public void apply(RequestTemplate requestTemplate) {

        //统一设置请求头
        requestTemplate.header("source","cloud-order");


    }
}