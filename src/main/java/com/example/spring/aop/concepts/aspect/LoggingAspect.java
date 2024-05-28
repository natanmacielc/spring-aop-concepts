package com.example.spring.aop.concepts.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.example.spring.aop.concepts.service.FooService.doSomething())")
    public void logBeforeMethodCall(JoinPoint joinPoint) {
        System.out.println( "Método interceptado: " + joinPoint.getSignature());
    }

    @Before("@annotation(UsingLoggingAspect)")
    public void logBeforeMethodCallWithAnnotation(JoinPoint joinPoint) {
        System.out.println( "Método interceptado com anotação: " + joinPoint.getSignature());
    }
}
