package com.steven.spring.aop.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author gaochuanjun
 * @since 14-9-18
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/spring/applicationContext.xml");
        PersonService personService = applicationContext.getBean(PersonService.class);
        String personName = "Jim";
        personService.addPerson(personName);
        personService.deletePerson(personName);
        personService.editPerson(personName);
        ((ClassPathXmlApplicationContext) applicationContext).close();
    }
}
