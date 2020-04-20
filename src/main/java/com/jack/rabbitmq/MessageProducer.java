package com.jack.rabbitmq;

import com.alibaba.fastjson.JSON;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by manchong on 2019/7/30.
 */

@Component
public class MessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    final static String EXCHANGE="jollychic.topic";
    final static String ROUTING_KEY="add.cart.time.live.queue";

    public void createMessage(String xid,String mess) {
        Message message = new Message(xid,mess);
        rabbitTemplate.convertAndSend(EXCHANGE,ROUTING_KEY, JSON.toJSONString(message));
    }

    public static class Message {
        private String xid;
        private String message;

        public Message(String xid, String message) {
            this.xid = xid;
            this.message = message;
            if(this.xid==null) {
                this.xid=UUID.randomUUID().toString();
                this.message= message +"==="+this.xid;
            }
        }

        public String getXid() {
            return xid;
        }

        public void setXid(String xid) {
            this.xid = xid;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

}
