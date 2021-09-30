package com.qf.controller;

import com.qf.Goods;
import com.qf.Result;
import com.qf.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

/**
 * <p>title: com.qf.controller</p>
 * <p>Company: wendao</p>
 * author zhuximing
 * date 2021/8/16
 * description:
 */
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Value("${server.port}")
    private String PORT;


    @RequestMapping("findById/{id}")
    public Goods findById(@PathVariable String id,@RequestHeader("token")String token) throws  Exception{

        Thread.sleep(1000);

        System.out.println("id"+id);
        System.out.println("token"+token);
        return  new Goods("小米"+PORT, 99);
    }


    @PostMapping("save")
    public HashMap save(@RequestBody Goods goods){

        System.out.println(goods);

        return new HashMap(){{
            put("code", 200);
            put("msg", "goods save success");
        }};
    }

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("a")
    public String a(){

        //远程调用cloud-jifen

        String forObject = restTemplate.getForObject("http://cloud-jifen/jifen/b", String.class);
        System.out.println(forObject);


        return "a";
    }


    @Autowired
    private IGoodsService goodsService;

    @RequestMapping("kcc")
    public Result kcc(Integer goodsId,Integer buyNum){

        Result kcc = goodsService.kcc(goodsId, buyNum);

        return kcc;
    }




    



}