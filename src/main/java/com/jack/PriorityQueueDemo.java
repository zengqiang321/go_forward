package com.jack;

import org.apache.commons.io.FileUtils;
import org.springframework.util.PatternMatchUtils;

import java.io.*;
import java.util.PriorityQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by manchong on 2020/4/24.
 */
public class PriorityQueueDemo {

    public static String find(String sourceString, String reg, int group) {
        if (sourceString == null || reg == null) {
            return null;
        }
        Matcher mat = Pattern.compile(reg).matcher(sourceString);
        if (mat.find()) {
            String result = mat.group(group);
            return result;
        }
        return null;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(10);
        queue.add(8);
        queue.add(1);
        queue.add(3);
        queue.add(9);
        queue.add(7);


        System.out.println(3 >> 1);


        String s="2020-05-06 17:40:05.331 [http-apr-8080-exec-3] 10.10.18.25 99a57c217277446c9f6f37285fb6e19a INFO  pc.biz - GET /refund adminId=1&charset=utf-8&ip=172.31.18.25&refundAmount=7.984691000&signType=SHA256&siteType=80&txnId=20200417234355702100000567743&userId=48680767&sign=f6906f31b17f25c6c5ed1d8736f0b5294f2b7c1aaa8f6a726a0a5a646a1af8ca&bizType=2&serialNumber=538397&remark=autoReturn";
//        String ss=find(s,"txnId=(.*?)&",1);
//        System.out.println(ss);
//
        try (
                BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("/Users/jack/Downloads/refund.txt")))) {
                String tmp=null;
                while ((tmp = br.readLine())!=null) {
                    String m=find(tmp,"refundAmount=(.*?)&",1);
                    String xip=find(tmp,".*?txnId=(.*?)&",1);
                    String userId=find(tmp,"userId=(.*?)&",1);
                    System.out.println(xip+"\t"+m+"\t");
                }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
