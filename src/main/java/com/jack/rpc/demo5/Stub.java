package com.jack.rpc.demo5;

import java.lang.reflect.Proxy;

/**
 * Created by manchong on 2020/5/18.
 */
public class Stub {

    public static Object getService(Class clazz) throws Exception{
        ProxyUser proxyUser = new ProxyUser();
        Object userService = Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz},
                proxyUser);
        return userService;
    }

}
