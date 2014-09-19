package com.steven.annotation;

import com.google.common.collect.Sets;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * @author gaochuanjun
 * @since 14-9-19
 */
public class TestAnnotation {

    public static void main(String[] args) {
        String CLASS_NAME = "com.steven.annotation.JavaEyer";
        try {
            Class test = Class.forName(CLASS_NAME);
            Method[] methods = test.getMethods();
            boolean flag = test.isAnnotationPresent(Description.class);
            if (flag) {
                Description des = (Description) test.getAnnotation(Description.class);
                System.out.println("描述：" + des.value());
                System.out.println("----------");
            }

            Set<Method> set = Sets.newHashSet();
            for (int i = 0; i < methods.length; i++) {
                boolean otherFlag = methods[i].isAnnotationPresent(Name.class);
                if (otherFlag)
                    set.add(methods[i]);
            }

            for (Method method : set) {
                Name name = method.getAnnotation(Name.class);
                System.out.println(name.originate());
                System.out.println("创建的社区：" + name.community());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
