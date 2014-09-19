package com.steven.reflection;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * @author gaochuanjun
 * @since 14-9-19
 */
public class ClassUtil {


    public static List<Class<?>> getAllAssignedClass(Class<?> cls) throws ClassNotFoundException {
        List<Class<?>> classes = Lists.newArrayList();
        for (Class<?> c : getClasses(cls)) {
            if (cls.isAssignableFrom(c) && !cls.equals(c))
                classes.add(c);
        }
        return classes;
    }


    public static List<Class<?>> getClasses(Class<?> cls) throws ClassNotFoundException {
        //String pk = cls.getPackage().getName();
        String pk="com.steven.spring.controller";
        String path = pk.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL url = classLoader.getResource(path);
        return getClasses(new File(url.getFile()), pk);
    }

    private static List<Class<?>> getClasses(File dir, String pk) throws ClassNotFoundException {
        List<Class<?>> classes = Lists.newArrayList();
        if (!dir.exists())
            return classes;
        for (File f : dir.listFiles()) {
            if (f.isDirectory())
                classes.addAll(getClasses(f, pk + "." + f.getName()));
            String name = f.getName();
            if (name.endsWith(".class")) {
                classes.add(Class.forName(pk + "." + name.substring(0, name.length() - 6)));
            }

        }
        return classes;
    }

    public static void main(String[] args) {
        System.out.println("接口实现类：");
        try {
            for (Class<?> c : getAllAssignedClass(Controller.class)) {
                System.out.println(c.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
