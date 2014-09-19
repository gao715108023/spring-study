package com.steven.spring.controller;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;

import java.util.Map;
import java.util.Set;

/**
 * @author gaochuanjun
 * @since 14-9-19
 */
public class LogAop implements ApplicationContextAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Controller.class);
        Set<String> keySet = beansWithAnnotation.keySet();
        for (String key : keySet) {
            System.out.println(key);
        }
    }
}
