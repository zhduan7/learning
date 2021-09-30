package com.api;

import com.qf.Jifen;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>title: com.api</p>
 * <p>Company: wendao</p>
 * author zhuximing
 * date 2021/8/17
 * description: 积分接口声明
 */
@FeignClient("cloud-jifen") //cloud-jifen服务名称
@RequestMapping("/jifen")
public interface JifenApi {

    @PostMapping(value = "/save")
    public Map save(@RequestBody Jifen jifen) ;


    @PostMapping(value = "/update")
    public Map update(@RequestBody Jifen jifen);

    @GetMapping(value = "/delete")
    public Map deleteById(@RequestParam("jifenId") Integer jifenId) ;


    @GetMapping(value = "/{jifenId}")
    public Jifen findJifenById(@PathVariable Integer jifenId);

    @GetMapping(value = "/search")
    public Jifen search(@RequestParam("uid") Integer uid, @RequestParam("type") String type);

    @PostMapping(value = "/searchByEntity")
    public List<Jifen> searchMap(@RequestBody  Jifen jifen);
}
