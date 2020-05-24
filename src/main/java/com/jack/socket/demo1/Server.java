package com.jack.socket.demo1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by manchong on 2020/5/23.
 */
public class Server {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8999);
        while (true) {
            Socket socket = serverSocket.accept(); //监听客户端请求

            ObjectInputStream in=new ObjectInputStream(socket.getInputStream());
            User user=(User)in.readObject();
            socket.shutdownInput();

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            if(user!=null && user.getUsername().equals("jack") && user.getPassword().equals("123456")) {
                out.writeUTF("登陆成功，欢迎用户:"+user.getUsername());
            } else {
                out.writeUTF("登陆失败，请重新尝试");
            }

            out.flush();

            socket.shutdownOutput();
             out.close();
             in.close();

            socket.close();


        }
    }


}
