package com.dongying.testt;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAspect {
    @Pointcut("execution(* com.dongying.controller.UserController.getmap())")
    public void test(){

    }
    @Before("test()")
    public void before(){
        System.out.println("before==================>");
    }
    @Around("test()")
    public Object Around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around-before==================>");
        Object res=jp.proceed();
        System.out.println("around-after==================>");
        return res;
    }
     @After("test()")
    public void After(){
        System.out.println("After==================>");
    }

}
