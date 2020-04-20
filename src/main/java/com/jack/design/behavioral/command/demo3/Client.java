package com.jack.design.behavioral.command.demo3;

/**
 * Created by manchong on 2020/4/17.
 */
public class Client {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Command command = new DoorOpenCommand();
        invoker.action(command);

        invoker.action(new DoorCloseCommand());

        //把一个请求封装成一个命令对象，将命令对象调用者（invoker），调用者根据具体的命令执行具体的业务
    }
}
