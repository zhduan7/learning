package com.qf.service;

import com.qf.Result;
import com.qf.TbOrder;

/**
 * <p>title: com.qf.service</p>
 * <p>Company: wendao</p>
 * author zhuximing
 * date 2021/8/25
 * description:
 */
public interface IOrderService {

    public Result saveOrder(TbOrder order);
}
