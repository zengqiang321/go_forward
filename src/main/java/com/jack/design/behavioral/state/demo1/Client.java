package com.jack.design.behavioral.state.demo1;

/**
 * 场景：
 *      我们每天都有乘坐电梯，电梯有，开，关，上，下，停止，状态。 如何用程序控制
 *      电梯初始状态，关闭。
 *      有人按上，下，电梯开门，
 *      开门：人进人出， 按楼层后 关门 进行上或下动作。 到达指定楼层，门口，在人进认出，关门 上下反复动作
 * Created by manchong on 2020/4/20.
 */
public class Client {

    public static void main(String[] args) {
        Lift lift = new Lift();
        lift.setNextState(LiftStateEnum.CLOSE.getState());
        lift.open();
        lift.setNextState(LiftStateEnum.UP.getState());
        lift.close();
        lift.setNextState(LiftStateEnum.STOP.getState());
        lift.up();
        lift.setNextState(LiftStateEnum.OPEN.getState());
        lift.open();
        lift.setNextState(LiftStateEnum.CLOSE.getState());
        lift.close();
        lift.setNextState(LiftStateEnum.DOWN.getState());
        lift.down();
        lift.setNextState(LiftStateEnum.OPEN.getState());
        lift.open();
    }

}
