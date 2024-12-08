package com.example.pethouseholdapp.aspect;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* service.*.*(..))")
    public void beforeMethod() {
        log.info("Executing method...");
    }

    @After("execution(* service.*.*(..))")
    public void afterMethod() {
        log.info("Method executed.");
    }

    @AfterReturning("execution(* service.*.*(..))")
    public void afterReturningMethod() {
        log.info("Method returned successfully.");
    }

    @AfterThrowing("execution(* service.*.*(..))")
    public void afterThrowingMethod() {
        log.error("Method threw an exception.");
    }

    @Around("execution(* service.*.*(..))")
    public void aroundMethod() {
        log.info("Around method execution.");
    }
}