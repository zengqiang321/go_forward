package com.jack.design.behavioral.state.demo3;

/**
 * Created by manchong on 2020/4/20.
 */
public class StopLiftState extends LiftState {

    public StopLiftState(Context context) {
        super(context);
    }

    @Override
    public void open() {
        System.out.println("电梯打开");
//        super.context.setLiftState(Context.closeable);
        super.context.getLiftState().close();
    }

    @Override
    public void close() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void up() {

    }

    @Override
    public void down() {

    }
}
