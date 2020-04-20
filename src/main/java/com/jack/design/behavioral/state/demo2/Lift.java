package com.jack.design.behavioral.state.demo2;

/**
 *
 * Created by manchong on 2020/4/20.
 */
public class Lift {

    private LiftStateEnum nextState;

    public void setNextState(LiftStateEnum nextState) {
        this.nextState=nextState;
    }


    public void open(){
        System.out.println("电梯开了，有人进，有人出.准备:"+nextState.getDes());
        switch (nextState) {
            case CLOSE:
                setNextState(LiftStateEnum.UP);
                close();
                break;
            case OPEN:
                //setNextState(LiftStateEnum.CLOSE);
                //setNextState(LiftStateEnum.DOWN);
                break;
            case UP:
                break;
            case DOWN:
                //setNextState(LiftStateEnum.STOP);
                //stop();
                break;
            case STOP:
                //setNextState(LiftStateEnum.OPEN);
                //open();
                break;
            default:
                System.out.println(nextState.getDes());
        }
    }

    public void close(){
        System.out.println("电梯关闭，禁止进出。准备:"+nextState.getDes());
        switch (nextState) {
            case CLOSE:
                //setNextState(LiftStateEnum.UP);
                //close();
                break;
            case OPEN:
                //setNextState(LiftStateEnum.CLOSE);
                //setNextState(LiftStateEnum.DOWN);
                break;
            case UP:
                setNextState(LiftStateEnum.STOP);
                stop();
                break;
            case DOWN:
                //setNextState(LiftStateEnum.STOP);
                //stop();
                break;
            case STOP:
                //setNextState(LiftStateEnum.OPEN);
                //open();
                break;
            default:
                System.out.println(nextState.getDes());
        }
    }

    public void stop() {
        System.out.println("电梯停止，禁止进出。准备:"+nextState.getDes());
        switch (nextState) {
            case CLOSE:
                //setNextState(LiftStateEnum.UP);
                //close();
                break;
            case OPEN:
                setNextState(LiftStateEnum.CLOSE);
                close();
                break;
            case UP:
                //setNextState(LiftStateEnum.STOP);
                //stop();
                break;
            case DOWN:
                //setNextState(LiftStateEnum.STOP);
                //stop();
                break;
            case STOP:
                //setNextState(LiftStateEnum.OPEN);
                //open();
                break;
            default:
                System.out.println(nextState.getDes());
        }
    }

    public void up() {
        System.out.println("电梯上行，禁止进出。准备:"+nextState.getDes());
        switch (nextState) {
            case CLOSE:
                //setNextState(LiftStateEnum.UP);
                //close();
                break;
            case OPEN:
                setNextState(LiftStateEnum.CLOSE);
                close();
                break;
            case UP:
                //setNextState(LiftStateEnum.STOP);
                //stop();
                break;
            case DOWN:
                //setNextState(LiftStateEnum.STOP);
                //stop();
                break;
            case STOP:
                //setNextState(LiftStateEnum.OPEN);
                //open();
                break;
            default:
                System.out.println(nextState.getDes());
        }
    }

    public void down(){
        System.out.println("电梯下行，禁止进出。准备:"+nextState.getDes());
        switch (nextState) {
            case CLOSE:
                //setNextState(LiftStateEnum.UP);
                //close();
                break;
            case OPEN:
                setNextState(LiftStateEnum.CLOSE);
                close();
                break;
            case UP:
                //setNextState(LiftStateEnum.STOP);
                //stop();
                break;
            case DOWN:
                //setNextState(LiftStateEnum.STOP);
                //stop();
                break;
            case STOP:
                setNextState(LiftStateEnum.OPEN);
                open();
                break;
            default:
                System.out.println(nextState.getDes());
        }
    }

}
