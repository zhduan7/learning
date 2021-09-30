package com.duan.goods;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Value;


@DubboService(version = "1.0.0", timeout = 3000)
public class DefaultDemoService implements DemoService {

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceName;

//    @Value("${server.port}")
    @Value("${dubbo.protocol.port}")
    private int port;

    public String sayHello(String name) {
        return String.format("[%s:%S] : Hello, %s", serviceName, port, name);
    }
}