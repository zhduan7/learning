package com.qf.sentinel;

import com.alibaba.csp.sentinel.slots.block.BlockException;

/**
 * <p>title: com.qf.sentinel</p>
 * <p>Company: wendao</p>
 * author zhuximing
 * date 2021/8/19
 * description:
 */
public class BlockExceptionHandler {


    //备选逻辑
    public static String test9Handler(String name, BlockException exception){


        return "系统繁忙，请稍后重试!!!";
    }
}