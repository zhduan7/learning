package com.qf.sentinel;

import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;

/**
 * <p>title: com.qf.sentinel</p>
 * <p>Company: wendao</p>
 * author zhuximing
 * date 2021/8/19
 * description:
 */
public class DegradeExceptionHandler {

    //备选
    public static String test6Handler(String flag,Throwable throwable)throws  Exception{


        if(throwable instanceof DegradeException){
            return "系统开小差，一会重试!!!";
        }else{
            return "非sentinel异常";
        }

    }
}