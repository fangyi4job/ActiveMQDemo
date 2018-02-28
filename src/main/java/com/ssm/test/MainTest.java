package com.ssm.test;

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


    @Test
    public void testService() {
        Student student = studentService.selectByID(1);
        System.out.println("***************");
        System.out.println(student);
    }
}
