package com.steven.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author gaochuanjun
 * @since 14-9-18
 */
@Component
@Aspect
public class SimpleAspect {

    @Pointcut("execution(* com.steven.spring.aop.aspect.*Service*.*(..))")
    public void pointCut() {

    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("after aspect executed");
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        System.out.println("before aspect executing");
    }

    @AfterReturning(pointcut = "pointCut()", returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint, Object returnVal) {
        Object object = joinPoint.getTarget();
        PersonService personService = (PersonService) object;
        System.out.println("test: " + personService.getPerson());
        System.out.println("afterReturning executed, return result is " + returnVal);
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint pjp) {
        System.out.println("around start...");
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around end");
    }

    @AfterThrowing(pointcut = "pointCut()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Throwable error) {
        System.out.println("error: " + error);
    }


}
