package com.jack.design.behavioral.state.demo3;

/**
 * Created by manchong on 2020/4/20.
 */
public class Context {

    private LiftState liftState;

    public void setLiftState(LiftState liftState) {
        this.liftState=liftState;
    }

    public LiftState getLiftState() {
        return liftState;
    }
}
