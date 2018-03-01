package com.ssm.test;

import com.ssm.activemq.producer.QueueSender;
import com.ssm.activemq.producer.TopicSender;
import com.ssm.domain.Student;
import com.ssm.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-*.xml"})
public class MainTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private QueueSender queueSender;

    @Autowired
    private TopicSender topicSender;


    @Test
    public void testService() {
        Student student = studentService.selectByID(1);
        System.out.println("***************");
        System.out.println(student);
    }

    @Test
    public void testAmq() {
        String msg = "你好，这是测试数据";
        String destQueue = "amq:queue";
        String destTopic = "amq.topic";

        //发送消息
//        queueSender.send(destQueue, msg);
        topicSender.send(destTopic, msg);

    }


}
