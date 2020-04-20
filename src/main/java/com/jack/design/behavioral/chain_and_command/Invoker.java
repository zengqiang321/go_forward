package com.jack.design.behavioral.chain_and_command;

/**
 * Created by manchong on 2020/4/16.
 */
public class Invoker<T> {

//    private Command command;
//    public Invoker (Command command) {
//        this.command = command;
//    }

    public T action(String _command){
        IPlayer player = new Player1(new Player2(new Player3(null)));
        Command command =null;
        if(_command.equals("1")) {
            command =new BeatDrumOnce(player);
        } else if(_command.equals("2")) {
            command =new BeatDrumTwo(player);
        }

        return (T)command.execute();
    }

}
