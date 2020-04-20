package com.jack.rabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

/**
 * 利用 时效消息+ 死信队列 实现消息延迟队列功能
 * Created by manchong on 2019/7/30.
 */
public class DeadLetterQueueConsumer implements ChannelAwareMessageListener {

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            String str = new String(message.getBody());
            System.out.println(str);
        }finally {
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }
    }
}
