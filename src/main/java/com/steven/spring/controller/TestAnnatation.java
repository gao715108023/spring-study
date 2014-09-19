package com.steven.spring.controller;

import com.google.common.collect.Sets;
import com.steven.annotation.Name;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

/**
 * @author gaochuanjun
 * @since 14-9-19
 */
public class TestAnnatation {
    public static void main(String[] args) {
        String CLASS_NAME = "com.steven.spring.controller.UserController";
        try {
            Class test = Class.forName(CLASS_NAME);
            Method[] methods = test.getMethods();
            boolean flag = test.isAnnotationPresent(RequestMapping.class);
            if (flag) {
                RequestMapping requestMapping = (RequestMapping) test.getAnnotation(RequestMapping.class);
                System.out.println("描述：" + Arrays.toString(requestMapping.value()));
                System.out.println("----------");
            }

            Set<Method> set = Sets.newHashSet();
            for (int i = 0; i < methods.length; i++) {
                boolean otherFlag = methods[i].isAnnotationPresent(RequestMapping.class);
                if (otherFlag)
                    set.add(methods[i]);
            }

            for (Method method : set) {
                RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                System.out.println(Arrays.toString(requestMapping.value()));
            }

            Set<Method> set1 = Sets.newHashSet();
            for (int i = 0; i < methods.length; i++) {
                boolean otherFlag = methods[i].isAnnotationPresent(Name.class);
                if (otherFlag)
                    set1.add(methods[i]);
            }

            for (Method method : set1) {
                Name name = method.getAnnotation(Name.class);
                System.out.println(name.community());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
