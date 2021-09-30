package com.qf.predicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * <p>title: com.qf.predicates</p>
 * <p>Company: wendao</p>
 * author zhuximing
 * date 2021/8/23
 * description:
 */
@Component
public class MyHeaderRoutePredicateFactory extends AbstractRoutePredicateFactory<MyConfig> {
    public MyHeaderRoutePredicateFactory() {
        super(MyConfig.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(MyConfig config) {




        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                //从请求头中获取key对应的value
                String value = serverWebExchange.getRequest().getHeaders().getFirst(config.getKey());
//                if(StringUtils.isEmpty(value)){
//
//                    return  false;
//                }else{
//                    if(value.equals(config.getValue())){
//
//                        return true;
//                    }else{
//                        return  false;
//                    }
//                }
                if(StringUtils.isEmpty(config.getValue())){

                    if(StringUtils.isEmpty(value)){
                        return false;
                    }else{
                        return  true;
                    }
                }else{
                        if(StringUtils.isEmpty(value)){
                            return  false;
                        }else{
                            if(value.equals(config.getValue())){

                                return true;
                            }else{
                                return  false;
                            }
                        }
                }




            }
        };
    }


    //- MyHeader=name,xx
    //name   =>Myconfig#key
    //xx     =>Myconfig#value

    @Override
    public List<String> shortcutFieldOrder() {
        return Arrays.asList("key","value");
    }
}