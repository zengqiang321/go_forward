package com.jack.rpc.demo3;

import com.jack.rpc.UserService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * Created by manchong on 2020/5/18.
 */
public class Stub {

    public static UserService getUserService() throws Exception{
        ProxyUser proxyUser = new ProxyUser();
        UserService userService = (UserService) Proxy.newProxyInstance(UserService.class.getClassLoader(),
                new Class[]{UserService.class},
                proxyUser);
        return userService;
    }

}
