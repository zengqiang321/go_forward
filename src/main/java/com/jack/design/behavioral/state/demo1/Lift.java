package com.jack.design.behavioral.state.demo1;

/**
 *
 * Created by manchong on 2020/4/20.
 */
public class Lift {

    private int nextState;

    public void setNextState(int nextState) {
        this.nextState=nextState;
    }

    public void open(){
        System.out.println("电梯开了，有人进，有人出.准备:"+LiftStateEnum.get(nextState).getDes());;
    }

    public void close(){
        System.out.println("电梯关闭，禁止进出。准备:"+LiftStateEnum.get(nextState).getDes());
    }

    public void stop() {
        System.out.println("电梯停止，禁止进出。准备:"+LiftStateEnum.get(nextState).getDes());
    }

    public void up() {
        System.out.println("电梯上行，禁止进出。准备:"+LiftStateEnum.get(nextState).getDes());
    }

    public void down(){
        System.out.println("电梯下行，禁止进出。准备:"+LiftStateEnum.get(nextState).getDes());
    }

}
