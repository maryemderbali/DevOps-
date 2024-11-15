package tn.esprit.firstproject.configuration;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Before("execution(* tn.esprit.firstproject.serviceIMP.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("Before method " + name + " : ");
    }

    @After("execution(* tn.esprit.firstproject.serviceIMP.*.*(..))")
    public void exitMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("After method " + name + " : ");
    }

    @AfterReturning("execution(* tn.esprit.firstproject.serviceIMP.*.*(..))")
    public void afterReturningMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("after returning method " + name + " : ");
    }
    @AfterThrowing("execution(* tn.esprit.firstproject.serviceIMP.*.*(..))")
    public void afterThrowingMethod(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        log.info("after throwing method " + name + " : ");
    }
}