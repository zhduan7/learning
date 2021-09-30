package com.qf.filters;

import cn.hutool.json.JSONUtil;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>title: com.qf.filters</p>
 * <p>Company: wendao</p>
 * author zhuximing
 * date 2021/8/23
 * description:
 */
//@Component
public class AuthFilter implements GlobalFilter, Ordered {


    //针对所有的路由进行过滤
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        //过滤器的前处理
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();
        String token = request.getHeaders().getFirst("token");
        if(StringUtils.isEmpty(token)){
            Map res = new HashMap(){{
                put("msg", "没有登录!!");
            }};
           return response(response,res);
        }else{
            if(!"123".equals(token)){
                Map res = new HashMap(){{
                    put("msg", "令牌无效!!");
                }};
                return response(response,res);
            }else{
                return  chain.filter(exchange);  //放行
            }
        }



    }

    private Mono<Void>  response(ServerHttpResponse response,Object msg){
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        String resJson = JSONUtil.toJsonPrettyStr(msg);
        DataBuffer dataBuffer = response.bufferFactory().wrap(resJson.getBytes());
        return response.writeWith(Flux.just(dataBuffer));//响应json数据
    }




    //数字越小越先执行
    @Override
    public int getOrder() {
        return 0;
    }
}