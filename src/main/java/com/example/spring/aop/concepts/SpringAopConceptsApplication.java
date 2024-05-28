package com.example.spring.aop.concepts;

import com.example.spring.aop.concepts.properties.ApplicationProperties;
import com.example.spring.aop.concepts.service.FooService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class SpringAopConceptsApplication {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = SpringApplication.run(SpringAopConceptsApplication.class, args)) {
            doStuff(context);
        }
    }

    private static void doStuff(ConfigurableApplicationContext context) {
        FooService fooService = (FooService) context.getBean("fooService");
        fooService.doSomething();
        fooService.doSomethingWithAnnotation();
    }
}
