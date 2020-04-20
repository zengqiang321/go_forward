package com.jack.jdk8.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by manchong on 2019/6/5.
 */
public class Goods implements Comparable<Goods> {
    private Long goodsId;
    private Integer goodsNum;
    private BigDecimal price;
    private BigDecimal promotePrice;
    private String title;
    private Boolean onsale;

    private List<Sku> skuList;

    public Goods(){}
    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPromotePrice() {
        return promotePrice;
    }

    public void setPromotePrice(BigDecimal promotePrice) {
        this.promotePrice = promotePrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getOnsale() {
        return onsale;
    }

    public void setOnsale(Boolean onsale) {
        this.onsale = onsale;
    }

    @Override
    public int compareTo(Goods o) {
        return this.getGoodsNum().compareTo(o.getGoodsNum());
    }

    public List<Sku> getSkuList() {
        return skuList;
    }

    public void setSkuList(List<Sku> skuList) {
        this.skuList = skuList;
    }
}
