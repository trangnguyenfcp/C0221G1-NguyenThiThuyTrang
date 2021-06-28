package com.example.logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Aspect
@Component
public class BookAspect {
    int count =0;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @AfterThrowing(pointcut = "execution(* com.example.controller.BookController.*(..))", throwing = "e")
    public void logAfterMethodThrowing(JoinPoint joinPoint, Exception e){
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.err.printf(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, methodName, args, e.getMessage()));
    }
    @AfterReturning(pointcut = "execution(* com.example.controller.BookController.set*(..))")
    public void logChange(JoinPoint joinPoint){
        System.err.printf(String.format("Something change"));
    }
    @AfterReturning(pointcut = "execution(* com.example.controller.BookController.*(..))")
    public void logNumbersOfUsers(JoinPoint joinPoint) {
        System.err.printf(String.format("Number of users: " + ++count));
    }
}
