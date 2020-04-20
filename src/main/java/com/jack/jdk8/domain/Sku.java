package com.jack.jdk8.domain;

import java.util.List;

/**
 * Created by manchong on 2019/6/5.
 */
public class Sku {

    private Long skuId;
    private Long goodsId;
    private String skuValue;


    private List<SkuImage> imageList;

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getSkuValue() {
        return skuValue;
    }

    public void setSkuValue(String skuValue) {
        this.skuValue = skuValue;
    }

    public List<SkuImage> getImageList() {
        return imageList;
    }

    public void setImageList(List<SkuImage> imageList) {
        this.imageList = imageList;
    }
}
