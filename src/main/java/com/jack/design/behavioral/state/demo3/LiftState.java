package com.jack.design.behavioral.state.demo3;

/**
 * Created by manchong on 2020/4/20.
 */
public abstract class LiftState {

    protected Context context;

    public LiftState(Context context){
        this.context=context;
    }

    public abstract void open();

    public abstract void close();

    public abstract void stop();

    public abstract void up();

    public abstract void down();


}
