package com.offcn.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class QuartzTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-quartz.xml");
    }
    @Test
    public void test01(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans-quartz.xml");
    }
}
