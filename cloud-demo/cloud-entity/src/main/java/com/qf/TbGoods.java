package com.qf;

import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import lombok.Data;
@Data
@TableName("tb_goods")
public class TbGoods implements Serializable {
        /**
        * 
        */
        @TableId(type = IdType.ASSIGN_ID)
        private Integer goodsId;
        /**
        * 
        */
        private Integer goodsStock;
        /**
        * 
        */
        private Double goodsPrice;
        /**
        * 
        */
        private String goodsName;
}