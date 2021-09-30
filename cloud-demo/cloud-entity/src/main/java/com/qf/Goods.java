package com.qf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>title: com.qf</p>
 * <p>Company: wendao</p>
 * author zhuximing
 * date 2021/8/16
 * description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {

    private String goodsName;

    private double price;

}