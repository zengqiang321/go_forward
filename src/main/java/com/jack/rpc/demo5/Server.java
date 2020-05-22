package com.jack.rpc.demo5;

import com.jack.rpc.UserService;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Created by manchong on 2020/5/17.
 */
public class Server {

    static Map<String,Object> beanMap = new HashMap<>();
    public static void main(String[] args) throws Exception {
        UserService userService = new UserServiceImpl();
        beanMap.put(UserService.class.getName(),userService);
        ServerSocket serverSocket = new ServerSocket(8060);
        System.out.println("等待请求接入");
        while (true) {
            Socket socket = serverSocket.accept();
            process(socket);
            socket.close();
        }
    }

    public static void process(Socket socket)throws Exception {
        ObjectInputStream din = new ObjectInputStream( socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        String requestMethod = din.readUTF();
        String returnType=din.readUTF();
        Class[] types =(Class[]) din.readObject();
        Object[] args =(Object[]) din.readObject();
        String className=din.readUTF();

        System.out.println("====客户端请求接口:"+requestMethod);

        Class<?> aClass = Class.forName(className);
        Object service=beanMap.get(aClass.getName());
        Object val = aClass.getDeclaredMethod(requestMethod, types).invoke(service, args);

        //动态代理,
        String name=(String)val;
        dout.writeUTF(name);
        dout.flush();
        dout.close();
        din.close();
    }

}
