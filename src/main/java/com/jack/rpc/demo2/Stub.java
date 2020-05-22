package com.jack.rpc.demo2;

import com.jack.rpc.UserService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by manchong on 2020/5/18.
 */
public class Stub {

    public static String getUser() throws Exception{
        Socket socket = new Socket("127.0.0.1",8060);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dout = new DataOutputStream(outputStream);
        dout.writeUTF(UserService.class.getName() +".getUser");
        dout.flush();
        System.out.println("客户端信息发送.请求接口...");

        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String name=dis.readUTF();
        dis.close();
        socket.close();
        return name;
    }

}
