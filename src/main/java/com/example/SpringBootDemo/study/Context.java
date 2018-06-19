package com.example.SpringBootDemo.study;

import com.example.SpringBootDemo.study.beans.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Context {
    public static void main(String[] args) {
        // 初始化IOC容器ApplicationContext
        // ClassPathXmlApplication从类路径中加载
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("xml/Beans.xml");
        HelloWorld helloWorld = applicationContext.getBean("helloWorld", HelloWorld.class);
        helloWorld.sayHello();
    }
}
