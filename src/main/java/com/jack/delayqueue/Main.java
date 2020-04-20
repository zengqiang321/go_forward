package com.jack.delayqueue;

import java.util.concurrent.DelayQueue;

/**
 * Created by manchong on 2019/7/31.
 */
public class Main {

    public static void main(String[] args) {
        DelayQueue<Message> delayQueue = new DelayQueue<>();
        delayQueue.add(new Message("message1",(System.currentTimeMillis()/1000)+10));
        delayQueue.add(new Message("message2",(System.currentTimeMillis()/1000)+11));
        delayQueue.add(new Message("message3",(System.currentTimeMillis()/1000)+8));
        delayQueue.add(new Message("message4",(System.currentTimeMillis()/1000)+5));
        while (true) {
            try {
                Message message = delayQueue.take();
                if(message==null) {
                    break;
                }
                System.out.println(message.getMessageBody());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
