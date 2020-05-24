package com.jack.socket.demo1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by manchong on 2020/5/23.
 */
public class Client {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8999);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        User user =getUser();
        out.writeObject(user);
        out.flush();
        socket.shutdownOutput();


        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        String resp=in.readUTF();
        System.out.println("收到服务端消息:"+resp);
        socket.shutdownInput();

        out.close();
        in.close();
        socket.close();

    }


    public static User getUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("请输入密码:");
        String password = scanner.nextLine();
        return new User(username,password);
    }

}
