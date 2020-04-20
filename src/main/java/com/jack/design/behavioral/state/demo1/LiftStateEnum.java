package com.jack.design.behavioral.state.demo1;

/**
 * Created by manchong on 2020/4/20.
 */
public enum LiftStateEnum {

    CLOSE(0,"关闭电梯"),
    OPEN(1,"打开电梯"),
    UP(2,"电梯上行"),
    DOWN(3,"电梯下行"),
    STOP(4,"电梯停止运行");

    private int state;
    private String des;

    LiftStateEnum(int state, String des) {
        this.state=state;
        this.des=des;
    }

    public static LiftStateEnum get(int state){
        for (LiftStateEnum liftState : values()) {
            if(liftState.state==state) {
                return liftState;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getDes() {
        return des;
    }
}
