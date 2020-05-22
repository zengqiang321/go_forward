package com.jack.rpc.demo3;

import com.jack.rpc.UserService;
import com.jack.rpc.demo1.UserServiceImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

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
        DataInputStream din = new DataInputStream( socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        String request = din.readUTF();
        System.out.println("====客户端请求接口:"+request);
        UserService userService = new UserServiceImpl();
        String name=userService.getUser();
        dout.writeUTF(name);
        dout.flush();
        dout.close();
        din.close();
    }

}
