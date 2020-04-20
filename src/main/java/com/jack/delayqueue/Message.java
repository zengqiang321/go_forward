package com.jack.delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by manchong on 2019/7/31.
 */
public class Message implements Delayed {

    private String messageBody;
    private Long expireTime;

    public Message(String messageBody,Long expireTime) {
        this.messageBody = messageBody;
        this.expireTime = expireTime;
    }


    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(expireTime,TimeUnit.SECONDS)  -
                unit.convert(System.currentTimeMillis()/1000,TimeUnit.SECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return this.getDelay(TimeUnit.SECONDS)>o.getDelay(TimeUnit.SECONDS)?1:-1;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }
}
