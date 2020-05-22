package com.jack.rpc.demo2;

/**
 * Created by manchong on 2020/5/17.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        String user= Stub.getUser();
        System.out.println(user);
    }



}
