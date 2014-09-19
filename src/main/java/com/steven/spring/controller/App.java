package com.steven.spring.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gaochuanjun
 * @since 14-9-19
 */
public class App {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");

        LogAop logAop = applicationContext.getBean(LogAop.class);
    }
}
