package com.jack.serialize;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by manchong on 2019/8/5.
 */
public class Order implements Serializable,Cloneable {

    private static final long serialVersionUID = 2925795830377796024L;
    private Long orderId;
    private Integer gmtCreated;
    private BigDecimal orderAmount;
    private Double orderPromotion;
    //内部类
    private User user;


    private List<OrderGoods> goodsList;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Integer gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public List<OrderGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderGoods> goodsList) {
        this.goodsList = goodsList;
    }

    public Double getOrderPromotion() {
        return orderPromotion;
    }

    public void setOrderPromotion(Double orderPromotion) {
        this.orderPromotion = orderPromotion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static class User implements Serializable/*,Cloneable*/{
        private static final long serialVersionUID = 3540054797669623456L;
        private Long userId;
        private String userName;


        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

//        @Override
//        protected User clone() throws CloneNotSupportedException {
//            return (User)super.clone();
//        }


        @Override
        public String toString() {
            return "User{" +
                    "userId=" + userId +
                    ", userName='" + userName + '\'' +
                    '}';
        }
    }

    @Override
    protected Order clone()  {
        try {
            Order order = (Order) super.clone();
            if (goodsList == null) {
                return order;
            }
            List<OrderGoods> cloneGoodsList = new ArrayList<>();
            for (OrderGoods orderGoods : goodsList) {
                cloneGoodsList.add(orderGoods.clone());
            }
            order.setGoodsList(cloneGoodsList);
            User user=order.getUser();
            if(user!=null) {
                order.setUser(user);
            }
            return order;
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (OrderGoods orderGoods : goodsList) {
            sb.append(orderGoods.toString()).append(",");
        }
        sb.append("]");
        return "Order{" +
                "orderId=" + orderId +
                ", gmtCreated=" + gmtCreated +
                ", orderAmount=" + orderAmount +
                ", goodsList=" + sb.toString() +
                ", user=" + user.toString() +
                '}';
    }
}
