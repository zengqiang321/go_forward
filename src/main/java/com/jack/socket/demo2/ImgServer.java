package com.jack.socket.demo2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by manchong on 2020/5/23.
 */
public class ImgServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8999);
        Socket socket = serverSocket.accept();

        InputStream in=socket.getInputStream();
        FileOutputStream out=new FileOutputStream(new File("bcd.jpg"));
        byte[] buffer=new byte[1024];
        int te=-1;
        while ((te=in.read(buffer))!=-1) {
            out.write(buffer);
        }
        out.flush();

        socket.shutdownOutput();
        out.close();
        socket.close();
        serverSocket.close();

    }
}
