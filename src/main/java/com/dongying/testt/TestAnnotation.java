package com.dongying.testt;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAnnotation {
    @Pointcut("@annotation(com.dongying.annotation.MyAnnotaion)")
    public void myAnnotation(){}
    @Before("myAnnotation()")
    public void before(){
        System.out.println("before==================>");
    }
    @Around("myAnnotation()")
    public Object Around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around-before==================>");
        Object res=jp.proceed();
        System.out.println("around-after==================>");
        return res;
    }
    @After("myAnnotation()")
    public void After(){
        System.out.println("After==================>");
    }
}
