package com.qf.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.api.GoodsApi;
import com.api.JifenApi;
import com.qf.Jifen;
import com.qf.Result;
import com.qf.TbOrder;
import com.qf.mapper.OrderMapper;
import com.sun.corba.se.spi.ior.IOR;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.UUID;

/**
 * <p>title: com.qf.service</p>
 * <p>Company: wendao</p>
 * author zhuximing
 * date 2021/8/18
 * description:
 */
@Service
public class OrderService  implements IOrderService {

    @Autowired
    private JifenApi jifenApi;


    @SentinelResource("saveOrder[jifen save]")
    public String saveOrder(){

        //发送远程调用   jifen save
        Map save = jifenApi.save(new Jifen(1, 1, "12"));

        System.out.println(save);
        System.out.println("order save success");


        return "success";
    }


    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsApi goodsApi;

    @Override
//    @Transactional
    @GlobalTransactional(timeoutMills = 100000)
    public Result saveOrder(TbOrder order) {
        order.setOrderId(UUID.randomUUID().toString());
        int insert = orderMapper.insert(order);

        Result kccReuslt = goodsApi.kcc(order.getGoodsId(), order.getOrderNum());

        int i = 1/0;
        return new Result(true, "下单成功");
    }
}