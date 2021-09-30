package com.qf.controller;

import com.qf.Jifen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jifen")
@RefreshScope
public class JifenController {



    //qps <=100
    @Value("${pic.url}")
    private String URL;
    @RequestMapping("test1")
    public String test1(){

        //耗时


        return URL;
    }



    //线程数/池=50
    @PostMapping(value = "/save")
    public Map save(@RequestBody Jifen jifen) {

        System.out.println("调用了积分保存接口");
        System.out.println(jifen);
        return new HashMap(){{
            put("isSuccess",true);
            put("msg","save success");
        }};

    }

    //线程数/池=50
    @PostMapping(value = "/update")
    public Map update(@RequestBody Jifen jifen) {

        System.out.println(jifen);
        return new HashMap(){{
            put("isSuccess",true);
            put("msg","update success");
        }};
 
    }
 
 
 
    @GetMapping(value = "/delete")
    public Map deleteById(Integer jifenId) {
        System.out.println("删除id为"+jifenId+"的积分信息");
        return new HashMap(){{
            put("isSuccess",true);
            put("msg","delete success");
        }};

    }
 
 
 
 
    @GetMapping(value = "/{jifenId}")
    public Jifen findJifenById(@PathVariable Integer jifenId) {
        System.out.println("已经查询到"+jifenId+"积分数据");
        return new Jifen(jifenId, 12,jifenId+"号积分");
    }
 
 
    @GetMapping(value = "/search")
    public Jifen search(Integer uid,String type) {
        System.out.println("uid:"+uid+"type:"+type);
        return new Jifen(uid, 12,type);
    }
 
    @PostMapping(value = "/searchByEntity")
    public List<Jifen> searchMap(@RequestBody  Jifen jifen) {
 
        System.out.println(jifen);
 
        List<Jifen> jifens = new ArrayList<Jifen>();
        jifens.add(new Jifen(110,12,"下单积分"));
        jifens.add(new Jifen(111,18,"支付积分"));
        return  jifens;
    }

    @Autowired
    private RestTemplate restTemplate;


    @RequestMapping("b")
    public String b(){

        //远程调用cloud-order
        String forObject = restTemplate.getForObject("http://cloud-order/order/c", String.class);


        System.out.println(forObject);

        int i = 1/0;
        return "b";
    }



    
 
}