package com.qf.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.api.GoodsApi;
import com.api.JifenApi;
import com.qf.Goods;
import com.qf.Jifen;
import com.qf.Result;
import com.qf.TbOrder;
import com.qf.sentinel.BlockExceptionHandler;
import com.qf.sentinel.DegradeExceptionHandler;
import com.qf.service.IOrderService;
import com.qf.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>title: com.qf.controller</p>
 * <p>Company: wendao</p>
 * author zhuximing
 * date 2021/8/16
 * description:
 */
@RestController
@RequestMapping("order")
public class OrderController {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//
//    @RequestMapping("save")
//    public Map save(){
//
//        //远程调用cloud-goods服务，获取goods信息,发送http请求(httpclient)=>resttemplate
//
//        String serviceName = "cloud-goods";
//        String url = "http://"+serviceName+"/goods/findById/1";
//        Goods goods = restTemplate.getForObject(url, Goods.class);
//
//        System.out.println(goods);
//
//        //2:保存订单
//        System.out.println("save order success!!");
//
//
//        return  new HashMap(){{
//            put("code", "200");
//            put("msg", "success");
//        }};
//
//    }
//
//    @RequestMapping("test")
//    public String test(){
//        String serviceName = "cloud-goods";
//        String url = "http://"+serviceName+"/goods/save";
//
//        Goods goods = new Goods("华为", 1);
//
//
//        HashMap hashMap = restTemplate.postForObject(url, goods, HashMap.class);
//
//        System.out.println(hashMap);
//
//        return "success";
//
//    }
//
//
//    @RequestMapping("test1")
//    public String test1(){
//        String serviceName = "cloud-goods";
//        String url = "http://"+serviceName+"/goods/save";
//
//        Goods goods = new Goods("华为", 1);
//
//
//        ResponseEntity<HashMap> result = restTemplate.postForEntity(url, goods, HashMap.class);
//
//        System.out.println(result.getBody());
//
//        System.out.println(result.getStatusCode());
//
//        return "success";
//
//    }
//
//
//    @RequestMapping("test2")
//    public Map test2(){
//
//        //远程调用cloud-goods服务，获取goods信息,发送http请求(httpclient)=>resttemplate
//
//        String serviceName = "cloud-goods";
//        String url = "http://"+serviceName+"/goods/findById/1";
//        ResponseEntity<Goods> result = restTemplate.getForEntity(url, Goods.class);
//
//        System.out.println(result.getBody());
//        System.out.println(result.getStatusCode());
//
//        //2:保存订单
//        System.out.println("save order success!!");
//
//
//        return  new HashMap(){{
//            put("code", "200");
//            put("msg", "success");
//        }};
//
//    }


    @Autowired
    private JifenApi iifenApi;


    @RequestMapping("test1")
    public Map test1(){

        //通过openfeign远程调用 cloud-jifen服务的/jifen/save接口
        Jifen jifen = new Jifen(1, 10, "2");

        //url:http://cloud-jifen/jifen/save
        Map save = iifenApi.save(jifen);

        return  save;
    }

    @RequestMapping("test2")
    public Map test2(){

        //通过openfeign远程调用 cloud-jifen服务的/jifen/save接口
        Jifen jifen = new Jifen(1, 10, "2");

        //url:http://cloud-jifen/jifen/save
        Map save = iifenApi.update(jifen);

        return  save;
    }

    @RequestMapping("test3")
    public Map test3(){


        //url  http://cloud-jifen/jifen/delete?jifenId=1
        Map deleteById = iifenApi.deleteById(1);

        return  deleteById;
    }

    @RequestMapping("test4")
    public Jifen test4(){

        //url  http://cloud-jifen/jifen/delete?jifenId=1
        Jifen jifenById = iifenApi.findJifenById(1);

        return  jifenById;
    }
    
    

//
//    @RequestMapping("test5")
//    public String test5()throws  Exception{
//
//        return  "test5";
//    }
//
//
//    @RequestMapping("test6")
//    public String test6()throws  Exception{
//
//        return  "test6";
//    }

//    @Autowired
//    private OrderService orderService;
//
//
//    @RequestMapping("test5")
//    public String test5()throws  Exception{
//
//        //jifen save
//        orderService.saveOrder();
//
//        return  "test5";
//    }
//
//
//    @RequestMapping("test6")
//    public String test6()throws  Exception{
//
//        //jifen save
//        orderService.saveOrder();
//        return  "test6";
//    }



    @RequestMapping("test5")
    public String test5(String flag)throws  Exception{

        if (flag == null) {

            Thread.sleep(1800);

        }

        return "test5";

    }

//    @RequestMapping("test6")
//    public String test6(String flag)throws  Exception{
//
//        if (flag == null) {
//
//            throw  new IllegalArgumentException("参数异常");
//
//        }
//
//        return "test6";
//
//    }


    //主逻辑
//    @RequestMapping("test6")
//    @SentinelResource(value = "test6",fallback = "test6Handler",fallbackClass = {DegradeExceptionHandler.class})
//    public String test6(String flag)throws  Exception{
//
//        if (flag == null) {
//
//            throw  new IllegalArgumentException("参数异常");
//
//        }
//
//        return "test6";
//
//    }



    //主逻辑
    @RequestMapping("test6")
    @SentinelResource(value = "test6")
    public String test6(String flag)throws  Exception{

        if (flag == null) {

            throw  new IllegalArgumentException("参数异常");

        }

        return "test6";

    }




    @RequestMapping("test7")
    @SentinelResource("hotkey-test7")
    public String test7(String name,Integer age){

        System.out.println("name"+name);
        System.out.println("age"+age);

        return "test7";
    }


    @Autowired
    private GoodsApi goodsApi;

    @RequestMapping("test8")
    public String test8(){

        Goods byId = goodsApi.findById("1");
        System.out.println(byId);


        return  "test8";
    }


//    //主逻辑
//    @RequestMapping("test9")
//    @SentinelResource(value="test9",blockHandler="test9Handler",blockHandlerClass = {BlockExceptionHandler.class})
//    public String test9(String name){
//
//
//        //todo ...
//
//        return "test9";
//    }


    //主逻辑
    @RequestMapping("test9")
    @SentinelResource(value="test9")
    public String test9(String name){


        //todo ...

        return "test9";
    }


    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();

        System.out.println(now);
    }


    @RequestMapping("c")
    public String c(){

        System.out.println("c");

        return "c";
    }

    @Autowired
    private IOrderService orderService;

    @RequestMapping("save")
    public Result save(@RequestBody TbOrder order){
        return orderService.saveOrder(order);
    }






}