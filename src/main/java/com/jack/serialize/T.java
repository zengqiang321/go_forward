package com.jack.serialize;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;

/**
 * Created by manchong on 2019/8/5.
 */
public class T {

    public static void main(String[] args) throws InterruptedException {



        Order orgOrder = OrderUtil.genOrder();
        System.out.println("愿数据："+orgOrder.toString()+"\n\n");
        Order copy = new Order();
        BeanUtils.copyProperties(orgOrder,copy);
        copy.setOrderAmount(BigDecimal.valueOf(1));
//
//        System.out.println(copy.getUser()==orgOrder.getUser());
//        copy.getUser().setUserId(2L);
//        copy.getUser().setUserName("asdfdd");
//
//
//
//
        System.out.println("原数据:"+orgOrder.toString()+"\n\n");
//
//
//
//
//        Order fastjsonOrder = SerialzationUtil.fastjsonSerial(orgOrder);
//        fastjsonOrder.setOrderAmount(BigDecimal.valueOf(10000D));

//        System.out.println("FastJson:原数据:"+orgOrder.toString()+"，\n变更后数据:"+fastjsonOrder.toString());
//        System.out.println("\n\n\n");
//
//        Order javaOrder = SerialzationUtil.javaSerial(orgOrder);
//        javaOrder.setOrderAmount(BigDecimal.valueOf(10001D));
//        System.out.println("javaOrder:原数据:"+orgOrder.toString()+"，\n变更后数据:"+javaOrder.toString());
//        System.out.println("\n\n\n");
//
//        Order gsonOrder = SerialzationUtil.gsonSerial(orgOrder);
//        gsonOrder.setOrderAmount(BigDecimal.valueOf(10002D));
//        System.out.println("gsonOrder:原数据:"+orgOrder.toString()+"，\n变更后数据:"+gsonOrder.toString());
//        System.out.println("\n\n\n");
//
//        Order kryoOrder = SerialzationUtil.kryoSerial(orgOrder);
//        kryoOrder.setOrderAmount(BigDecimal.valueOf(10003D));
//        System.out.println("kryoOrder:原数据:"+orgOrder.toString()+"，\n变更后数据:"+kryoOrder.toString());

//        long time1= System.currentTimeMillis();
        for (int i=0;i<1;i++) {
//            Order order= SerialzationUtil.javaSerial(orgOrder);
//            System.out.println(order.toString()+"\n\n"+"==");
//            order=SerialzationUtil.fastjsonSerial(orgOrder);
//            System.out.println(order.toString()+"\n\n"+"==");
//            order = SerialzationUtil.gsonSerial(orgOrder);
//            System.out.println(order.toString()+"\n\n"+"==");
//            order = SerialzationUtil.kryoSerial(orgOrder);
//            System.out.println(order.toString()+"\n\n"+"==");
//           Order order =SerialzationUtil.deepClone(orgOrder);
//            System.out.println(order.toString());
//            order.getUser().setUserName("ad");
//            System.out.println(orgOrder.getUser().getUserName());
        }
//        long time2 =System.currentTimeMillis();
//        System.out.println(time2-time1);

        //5712  1110  1258  1543    35

    }

}
