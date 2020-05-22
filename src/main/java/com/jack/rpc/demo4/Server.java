package com.jack.rpc.demo4;

import com.jack.rpc.UserService;
import com.jack.rpc.demo1.UserServiceImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by manchong on 2020/5/17.
 */
public class Server {


    public static void main(String[] args) throws Exception {

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

        String key=returnType+"/"+requestMethod;
        System.out.println("====客户端请求接口:"+requestMethod);

        UserService userService = new com.jack.rpc.demo4.UserServiceImpl();
        Object val = userService.getClass().getDeclaredMethod(requestMethod, types).invoke(userService, args);

        //动态代理,
        String name=(String)val;
        dout.writeUTF(name);
        dout.flush();
        dout.close();
        din.close();
    }

}
