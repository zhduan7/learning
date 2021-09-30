package com.qf;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import java.io.Serializable;
@Data
@TableName("tb_order")
public class TbOrder implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.ASSIGN_ID)
    private String orderId;
    /**
     *
     */
    private Integer orderNum;
    /**
     *
     */
    private Double orderAmount;
    /**
     *
     */
    private Integer goodsId;
}