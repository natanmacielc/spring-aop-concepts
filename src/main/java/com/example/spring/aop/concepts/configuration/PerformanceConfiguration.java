package com.example.spring.aop.concepts.configuration;

import com.example.spring.aop.concepts.interceptor.PerformanceInterceptor;
import com.example.spring.aop.concepts.properties.ApplicationProperties;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class PerformanceConfiguration {
    @Autowired
    public PerformanceConfiguration(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }
    private final ApplicationProperties applicationProperties;

    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }

    @Bean
    public Advisor performanceAdvisor(PerformanceInterceptor performanceInterceptor) {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(applicationProperties.getPerformance());
        return new DefaultPointcutAdvisor(pointcut, performanceInterceptor);
    }
}
