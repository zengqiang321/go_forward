package com.jack.socket.demo2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by manchong on 2020/5/23.
 */
public class ImgClient {
    public static void main(String[] args) throws IOException {
        Socket sockect =new Socket("127.0.0.1",8999);
        OutputStream out = sockect.getOutputStream();
        byte[] buf = new byte[1024];
        int i=0;
        FileInputStream fin = new FileInputStream(new File("/Users/jack/IdeaProjects/myproject/go_forward/src/main/java/com/jack/socket/demo2/1.jpg"));
        while ((i=fin.read(buf))!=-1) {
            out.write(buf);
        }
        fin.close();
        sockect.shutdownOutput();
        sockect.close();
    }
}
