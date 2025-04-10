package com.example.aop;

import android.util.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogExecutionAspect {

    @Pointcut("execution(@com.example.aop.LogExecutionTime * *(..))")
    public void annotatedWithLogExecutionTime() {}

    @Around("annotatedWithLogExecutionTime()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // exécute la méthode

        long duration = System.currentTimeMillis() - start;

        Log.d("AOP", joinPoint.getSignature() + " took " + duration + " ms");

        return result;
    }
}