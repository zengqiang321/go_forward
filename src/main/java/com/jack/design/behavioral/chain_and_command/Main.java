package com.jack.design.behavioral.chain_and_command;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by manchong on 2020/4/14.
 */
public class Main {

    public static void main(String[] args) throws IOException {

//        Response resp = player.handler();
//        System.out.println(resp);
//
//        resp = player.handler(3);
//        System.out.println(resp);


        Invoker<Response> invoker = new Invoker();
        while (true) {
            System.out.println("###");
            String _command= new BufferedReader(new InputStreamReader(System.in)).readLine();
            if("".equals(_command)){
                continue;
            }
            if(_command.equals("exit")) {
                return;
            }
            Response resp= invoker.action(_command);
            System.out.println(resp);
        }



    }
}
