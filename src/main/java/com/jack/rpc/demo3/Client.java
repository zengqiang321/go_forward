package com.jack.rpc.demo3;

import com.jack.rpc.UserService;

/**
 * Created by manchong on 2020/5/17.
 */
public class Client {

    public static void main(String[] args) throws Exception {
        UserService userService= Stub.getUserService();
        System.out.println(userService.getUser());
    }



}
