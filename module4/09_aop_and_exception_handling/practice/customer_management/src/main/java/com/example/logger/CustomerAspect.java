package com.example.logger;

import com.example.exception.CustomerException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class CustomerAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @AfterThrowing(pointcut = "execution(* com.example.controller.CustomerController.*(..))", throwing = "e")
    public void logAfterMethodThrowing(JoinPoint joinPoint, Exception e){
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.err.printf(String.format("[CMS] co loi xay ra: %s.%s%s: %s", className, methodName, args, e.getMessage()));
    }
}
