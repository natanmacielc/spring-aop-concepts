package com.example.spring.aop.concepts.service;

import com.example.spring.aop.concepts.aspect.UsingLoggingAspect;
import org.springframework.stereotype.Service;

@Service
public class FooService {
    public void doSomething() {
        try {
            Thread.sleep(1000);
            System.out.println("end do something");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @UsingLoggingAspect
    public void doSomethingWithAnnotation() {
        try {
            Thread.sleep(1000);
            System.out.println("end do something with annotation");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
