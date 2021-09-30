package com.qf.service.impl;

import com.qf.Result;
import com.qf.TbGoods;
import com.qf.mapper.GoodsMapper;
import com.qf.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>title: com.qf.service.impl</p>
 * <p>Company: wendao</p>
 * author zhuximing
 * date 2021/8/25
 * description:
 */
@Service
public class GoodsService  implements IGoodsService {

    @Autowired
    private GoodsMapper goodsMapper;


    @Override
    public Result kcc(Integer goodsId, Integer buyNum) {
        if(StringUtils.isEmpty(goodsId)){

            return  new Result(false, "参数不合法");
        }

        //....
        TbGoods tbGoods = goodsMapper.selectById(goodsId);
        if (tbGoods == null)
            return  new Result(false, "商品不存在");


        tbGoods.setGoodsStock(tbGoods.getGoodsStock()-buyNum);

        int i = goodsMapper.updateById(tbGoods);

        return new Result(i==1?true:false, i==1?"修改成功":"修改失败");
    }
}