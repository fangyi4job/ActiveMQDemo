package com.ssm.controller;

import com.ssm.activemq.producer.QueueSender;
import com.ssm.activemq.producer.TopicSender;
import com.ssm.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 蓝鸥科技有限公司  www.lanou3g.com.
 */
@Controller
public class MainController {
    @Resource
    private StudentService studentService;

    @Autowired
    private QueueSender queueSender;

    @Autowired
    private TopicSender topicSender;

    /*定义一个静态的map对象，存储各个监听器接收消息的情况*/
    public static Map<String, String> map =
            new HashMap<>();

    /**
     * 配置起始页
     * http://localhost:8080
     * http://localhost:8080/
     * http://localhost:8080/index
     **/
    @RequestMapping(
            value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @RequestMapping("/consumer")
    public String consumer() {
        return "consumer";
    }

    @ResponseBody
    @RequestMapping("/queueSender")
    public String queueSender(String message) {

        try {
            //发送消息之前先将map清空
            map.clear();
            //为了保证在发送消息前map是干净的，先稍微等一会
            Thread.sleep(100);

            queueSender.send(
                    "amq:queue", message);
            return "suc";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @ResponseBody
    @RequestMapping("/topicSender")
    public String topicSender(String message) {
        try {
            //发送消息之前先将map清空
            map.clear();
            //为了保证在发送消息前map是干净的，先稍微等一会
            Thread.sleep(100);

            topicSender.send(
                    "amq.topic", message);
            return "suc";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @ResponseBody
    @RequestMapping("/getMessage")
    public String getMessage() {
        return map.toString();
    }


}
