package com.ssm.activemq.consumer.topic;

import com.ssm.controller.MainController;
import com.ssm.util.TimeUtil;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Component
public class TopicReceiver1 implements MessageListener {

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

//        String text = textMessage.toString();


        String text = null;
        try {
            text = TimeUtil.getCurrentTime()
                    + " : " + textMessage.getText();

            //将收到的消息放入map中
            MainController.map.put("TopicReceiver1", text);

        } catch (JMSException e) {
            e.printStackTrace();
        }

        System.out.println("TopicReceiver1-->接收到的消息体为：" + text);
    }
}
