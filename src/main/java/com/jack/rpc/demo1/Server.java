package com.jack.rpc.demo1;

import com.jack.rpc.UserService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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
            break;
        }
    }

    public static void process(Socket socket)throws Exception {
        System.out.println("请求来了");

        DataInputStream din = new DataInputStream( socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
//        byte[] b=new byte[1024*8];
//        StringBuilder sb = new StringBuilder();
//        int len=-1;
//        while ((len=data.read(b))!=-1) {
//            sb.append(new String(b,0,len));
//        }
//        System.out.println("==="+sb.toString());
        String request = din.readUTF();
        System.out.println("===="+request);



        UserService userService = new UserServiceImpl();
        String name=userService.getUser();
        dout.writeUTF(name);
        dout.flush();

        dout.close();
        din.close();

    }

}
