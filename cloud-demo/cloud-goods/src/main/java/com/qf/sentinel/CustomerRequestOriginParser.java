package com.qf.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class CustomerRequestOriginParser implements RequestOriginParser {


    public String parseOrigin(HttpServletRequest request) {

        System.out.println("come in");

        //获取请求头的source
        String source1 = request.getHeader("source");
        System.out.println(source1);
        return source1;
    }
}