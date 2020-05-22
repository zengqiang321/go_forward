package com.jack.rpc.demo1;

import com.jack.rpc.UserService;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by manchong on 2020/5/17.
 */
public class Client {

    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("127.0.0.1",8060);
       String s= process(socket);
        System.out.println(s);
    }


    public static String process(Socket socket) throws  Exception{
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dout = new DataOutputStream(outputStream);
        dout.writeUTF(UserService.class.getName() +".getUser");
        dout.flush();
        System.out.println("客户端信息发送.请求接口...");

//        socket.shutdownOutput();



        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String name=dis.readUTF();
//        InputStream in = socket.getInputStream();
//        byte[] b= new byte[1024*8];
//
//        StringBuilder sb = new StringBuilder();
//        int len=-1;
//        while ((len=in.read(b))!=-1){
//            sb.append(new String(b,0,len));
//        }
//        System.out.println(sb.toString());

        dis.close();
        socket.close();
        return name;
    }
}
