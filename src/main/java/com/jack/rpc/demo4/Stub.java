package com.jack.rpc.demo4;

import com.jack.rpc.UserService;

import java.lang.reflect.Proxy;

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
