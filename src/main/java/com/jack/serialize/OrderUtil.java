package com.jack.serialize;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by manchong on 2019/8/5.
 */
public class OrderUtil {

    public static Order genOrder() {

        Order order = new Order();
        order.setGmtCreated((int)(System.currentTimeMillis()/1000L));
        order.setOrderAmount(BigDecimal.valueOf(1000D));
        order.setOrderId(100L);
        order.setOrderPromotion(1.034D);
        order.setUser(genUser());

        List<OrderGoods> goodsList =new ArrayList();

        goodsList.add(genOrderGoods(1,100D, OrderGoods.GoodsType.FLASH_SALE));
        goodsList.add(genOrderGoods(2,10D, OrderGoods.GoodsType.SECKILL));

        order.setGoodsList(goodsList);
        return order;
    }

    public static Order.User genUser() {
        Order.User user = new Order.User();
        user.setUserId(1L);
        user.setUserName("jack");
        return user;
    }

    public static OrderGoods genOrderGoods(Integer goodsId, Double price, OrderGoods.GoodsType goodsType) {
        OrderGoods orderGoods = new OrderGoods();
        orderGoods.setGoodsId(goodsId);
        orderGoods.setPrice(BigDecimal.valueOf(price));
        orderGoods.setTitle("title:"+System.currentTimeMillis());
        orderGoods.setGoodsType(goodsType);
        return orderGoods;
    }
}
