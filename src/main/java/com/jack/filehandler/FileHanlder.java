package com.jack.filehandler;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

/**
 * Created by manchong on 2020/5/14.
 */
public class FileHanlder {


    public static void main(String[] args) throws Exception{

//        Map<Long,String> mpa = new HashMap();
//        BufferedReader br  = new BufferedReader( new InputStreamReader(new FileInputStream("/Users/jack/Downloads/refund_result.txt")));
//        String tmp =null;
//        System.out.println("退款结果,refundSerialNumber,transactionId,refundMoney,currency,sourceId,userId");
//        while ((tmp = br.readLine())!=null) {
//            tmp=tmp.trim();
//            DTO dto= JSON.parseObject(tmp,DTO.class);
//            String str=dto.getRefundResult()+","+dto.getRefundSerialNumber()+","+dto.getTransactionId()+","+dto.getRefundMoney()+","+dto.getCurrency()+","+dto.getSourceId()+","+dto.getUserId();
//            System.out.println(str);
//            mpa.put(dto.getSourceId(),str);
//        }
//        br.close();
//
//        List<String> stlist = new ArrayList<>();
//        BufferedReader br1  = new BufferedReader( new InputStreamReader(new FileInputStream("/Users/jack/Downloads/MQ_Refund.txt")));
//        String tmp1 =null;
//        System.out.println("orderId,userId,refundAmount,transactionNumber");
//        while ((tmp1 = br1.readLine())!=null) {
//            tmp1=tmp1.trim();
//            MQ dto= JSON.parseObject(tmp1,MQ.class);
//            String str=dto.getOrderId()+","+dto.getUserId()+","+dto.getRefundAmount()+","+dto.getTransactionNumber();
//            System.out.println(str);
//            if(mpa.containsKey(dto.getOrderId())) {
//                String a=mpa.remove(dto.getOrderId());
//                stlist.add(str+","+a);
//            }else {
//                stlist.add(str);
//            }
//        }
//
//        Iterator<Map.Entry<Long, String>> it = mpa.entrySet().iterator();
//        while (it.hasNext()) {
//            stlist.add(it.next().getValue());
//        }
//
//        br1.close();
//
//        FileUtils.writeLines(new File("/Users/jack/Downloads/merge.csv"),stlist);



//        test1();
//        test2();
//        test3();
            test4();
    }


    public static void test3() throws Exception {
        BufferedReader br  = new BufferedReader( new InputStreamReader(new FileInputStream("/Users/jack/Downloads/merge_jolly_pay.txt")));
        String tmp =null;
        Map<String,String> map = new HashMap<>();

        while ((tmp = br.readLine())!=null) {
            tmp=tmp.trim();
            try {
                String traId = tmp.split(",")[0];
                System.out.println("====="+traId);
                map.put(traId,tmp.replaceAll("\t",","));
            } catch (Exception e){
                System.out.println(tmp);
            }

        }
        br.close();

        List<String> stlist = new ArrayList<>();
        List<String> stlist2 = new ArrayList<>();
        BufferedReader br1  = new BufferedReader( new InputStreamReader(new FileInputStream("/Users/jack/Downloads/merge_notmatch_JP.csv")));
        String tmp1 =null;
        while ((tmp1 = br1.readLine())!=null) {
            tmp1=tmp1.trim();

            try {
                String traId = tmp1.split(",")[0];
                System.out.println("<><><><>>"+traId);
                if (map.containsKey(traId)) {
                    String s = map.get(traId);
                    stlist.add( tmp1+s);
                } else {
                     stlist.add(tmp1);
                }
            }catch (Exception e){
                System.out.println(tmp1);
            }
        }

//        //合并JP支付状态
        FileUtils.writeLines(new File("/Users/jack/Downloads/merge_jolly_pay__notmatch_JP.txt"),stlist);

    }



    public static void test4() throws Exception {
        BufferedReader br  = new BufferedReader( new InputStreamReader(new FileInputStream("/Users/jack/Downloads/Adyen.txt")));
        String tmp =null;
        Map<String,String> map = new HashMap<>();
        while ((tmp = br.readLine())!=null) {
            tmp=tmp.trim();
            try {
                String traId = tmp.split(",")[0];
                System.out.println("====="+traId);
                map.put(traId,tmp.replaceAll("\t",","));
            } catch (Exception e){
                System.out.println(tmp);
            }

        }
        br.close();

        List<String> stlist = new ArrayList<>();
        List<String> stlist2 = new ArrayList<>();
        BufferedReader br1  = new BufferedReader( new InputStreamReader(new FileInputStream("/Users/jack/Downloads/222.txt")));
        String tmp1 =null;
        while ((tmp1 = br1.readLine())!=null) {
            tmp1=tmp1.trim();

            try {
                String traId = tmp1.split(",")[0];
                System.out.println("<><><><>>"+traId);
                if (map.containsKey(traId)) {
                    String s = map.get(traId);
                    stlist.add(s + "," + tmp1);
                } else {
                     stlist2.add(tmp1);
                }
            }catch (Exception e){
                System.out.println(tmp1);
            }
        }

//        //合并JP支付状态
        FileUtils.writeLines(new File("/Users/jack/Downloads/merge_jolly_edeny_.txt"),stlist);
        FileUtils.writeLines(new File("/Users/jack/Downloads/merge_jolly_edeny_222_.txt"),stlist2);

    }


    public static void test2() throws Exception {
        BufferedReader br  = new BufferedReader( new InputStreamReader(new FileInputStream("/Users/jack/Downloads/jolly_pay_txt.txt")));
        String tmp =null;
        Map<String,String> map = new HashMap<>();
        while ((tmp = br.readLine())!=null) {
            tmp=tmp.trim();
            try {
                String traId = tmp.split(",")[1];
                System.out.println("====="+traId);
                map.put(traId,tmp.replaceAll("\t",","));
            } catch (Exception e){
                System.out.println(tmp);
            }

        }
        br.close();

        List<String> stlist = new ArrayList<>();
        List<String> stlist2 = new ArrayList<>();
        BufferedReader br1  = new BufferedReader( new InputStreamReader(new FileInputStream("/Users/jack/Downloads/jolly_pay_txt2.txt")));
        String tmp1 =null;
        while ((tmp1 = br1.readLine())!=null) {
            tmp1=tmp1.trim();

            try {
                String traId = tmp1.split(",")[2];
                System.out.println("<><><><>>"+traId);
                if (map.containsKey(traId)) {
                    String s = map.get(traId);
                    stlist.add(s + "," + tmp1);
                } else {
                   // stlist2.add(tmp1);
                }
            }catch (Exception e){
                System.out.println(tmp1);
            }
        }

//        //合并JP支付状态
        FileUtils.writeLines(new File("/Users/jack/Downloads/merge_jolly_pay.txt"),stlist);

    }




    public static void test1() throws Exception {
        BufferedReader br  = new BufferedReader( new InputStreamReader(new FileInputStream("/Users/jack/Downloads/jp_res.txt")));
        String tmp =null;
        Map<String,String> map = new HashMap<>();
        while ((tmp = br.readLine())!=null) {
            tmp=tmp.trim();
            try {
                String traId = tmp.split(",")[2];
                System.out.println("====="+traId);
                map.put(traId,tmp.replaceAll("\t",","));
            } catch (Exception e){
                System.out.println(tmp);
            }

        }
        br.close();

         List<String> stlist = new ArrayList<>();
         List<String> stlist2 = new ArrayList<>();
        BufferedReader br1  = new BufferedReader( new InputStreamReader(new FileInputStream("/Users/jack/Downloads/merge.csv")));
        String tmp1 =null;
        while ((tmp1 = br1.readLine())!=null) {
            tmp1=tmp1.trim();

            try {
                String traId = tmp1.split(",")[3];
                System.out.println("<><><><>>"+traId);
                if (map.containsKey(traId)) {
                    String s = map.get(traId);
                    stlist.add(s + "," + tmp1);
                } else {
                    stlist2.add(tmp1);
                }
            }catch (Exception e){
                System.out.println(tmp1);
            }
        }

//        //合并JP支付状态
        FileUtils.writeLines(new File("/Users/jack/Downloads/merge_match_JP.csv"),stlist);
        FileUtils.writeLines(new File("/Users/jack/Downloads/merge_notmatch_JP.csv"),stlist2);

    }


    public static class MQ{
        private Long orderId;
        private String userId;
        private String refundAmount;
        private String transactionNumber;

        public Long getOrderId() {
            return orderId;
        }

        public void setOrderId(Long orderId) {
            this.orderId = orderId;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getRefundAmount() {
            return refundAmount;
        }

        public void setRefundAmount(String refundAmount) {
            this.refundAmount = refundAmount;
        }

        public String getTransactionNumber() {
            return transactionNumber;
        }

        public void setTransactionNumber(String transactionNumber) {
            this.transactionNumber = transactionNumber;
        }
    }



    public static class DTO{

            private String refundSerialNumber;
            private String refundResult;
            private String transactionId;
            private String refundMoney;
            private String currency;
            private Long sourceId;
            private String sourceType;
            private Integer userId;

        public String getRefundSerialNumber() {
            return refundSerialNumber;
        }

        public void setRefundSerialNumber(String refundSerialNumber) {
            this.refundSerialNumber = refundSerialNumber;
        }

        public String getRefundResult() {
            return refundResult;
        }

        public void setRefundResult(String refundResult) {
            this.refundResult = refundResult;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getRefundMoney() {
            return refundMoney;
        }

        public void setRefundMoney(String refundMoney) {
            this.refundMoney = refundMoney;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public Long getSourceId() {
            return sourceId;
        }

        public void setSourceId(Long sourceId) {
            this.sourceId = sourceId;
        }

        public String getSourceType() {
            return sourceType;
        }

        public void setSourceType(String sourceType) {
            this.sourceType = sourceType;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }
    }

}
