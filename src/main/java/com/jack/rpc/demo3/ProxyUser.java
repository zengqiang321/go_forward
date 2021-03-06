package com.jack.rpc.demo3;

import com.jack.rpc.UserService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

/**
 * Created by manchong on 2020/5/18.
 */
public class ProxyUser implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理");
        return process(method,args);
    }


    protected Object process(Method method,Object[] args) throws Exception{
        Socket socket = new Socket("127.0.0.1",8060);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dout = new DataOutputStream(outputStream);
        dout.writeUTF(method.getName());//方法名
        dout.writeUTF(method.getReturnType().getName());//返回类型

        dout.flush();
        System.out.println("客户端信息发送.请求接口...");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String name=dis.readUTF();
        dis.close();
        socket.close();
        return name;
    }
}
