package com.api;

import com.qf.Goods;
import com.qf.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient("cloud-goods")
@RequestMapping("goods")
public interface GoodsApi {

    @RequestMapping("findById/{id}")
    public Goods findById(@PathVariable String id);


    @RequestMapping("kcc")
    public Result kcc(@RequestParam("goodsId") Integer goodsId, @RequestParam("buyNum") Integer buyNum);

}