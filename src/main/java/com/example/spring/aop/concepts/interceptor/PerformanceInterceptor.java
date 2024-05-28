package com.example.spring.aop.concepts.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.util.Date;

public class PerformanceInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String name = invocation.getMethod().toString();
        long start = System.currentTimeMillis();
        System.out.println("Metodo " + name + " iniciado em: " + new Date());
        try {
            return invocation.proceed();
        } finally {
            long end = System.currentTimeMillis();
            long time = end - start;
            System.out.println("Metodo " + name + " executado em: " + time + " ms");
            System.out.println("Metodo " + name + " finalizado em: " + new Date());
            if (time > 10) {
                System.out.println("Execucao do metodo maior que 10ms!");
            }
        }
    }
}
