package com.ssm.activemq.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Component
public class QueueSender {

    @Autowired
    @Qualifier("jmsQueueTemplate")
    private JmsTemplate jmsTemplate;

    public void send(String destName, final String msg) {
        jmsTemplate.send(destName, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                //创建一个简单的文本消息
                Message message = session
                        .createTextMessage(msg);
                return message;
            }
        });
    }

}
