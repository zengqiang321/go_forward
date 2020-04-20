package com.jack.serialize;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by manchong on 2019/8/5.
 */
public class OrderGoods implements Serializable,Cloneable {

    private static final long serialVersionUID = 3316211493862300835L;

    private Integer goodsId;
    private String  title;
    private BigDecimal price;
    private GoodsType goodsType;

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public GoodsType getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsType goodsType) {
        this.goodsType = goodsType;
    }

    public enum GoodsType {
        SECKILL(0),
        FLASH_SALE(1);
        private int type;
        GoodsType(int type) {
            this.type=type;
        }

        public int getType() {
            return type;
        }

        public static GoodsType getType(int type) {
            for (GoodsType t: values()) {
                if(t.type==type){
                    return t;
                }
            }
            return null;
        }

    }

    @Override
    protected OrderGoods clone() throws CloneNotSupportedException {
        OrderGoods orderGoods=(OrderGoods) super.clone();
        if(orderGoods.getGoodsType()==null) {
            return orderGoods;
        }
        switch (orderGoods.goodsType){
            case SECKILL:orderGoods.setGoodsType(GoodsType.SECKILL);break;
            case FLASH_SALE:orderGoods.setGoodsType(GoodsType.FLASH_SALE);break;
            default:break;
        }
        return orderGoods;
    }

    @Override
    public String toString() {
        return "OrderGoods{" +
                "goodsId=" + goodsId +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", goodsType=" + goodsType +
                '}';
    }
}
