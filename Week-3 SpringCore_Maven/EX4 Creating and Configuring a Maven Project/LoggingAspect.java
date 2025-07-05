package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
public class LoggingAspect {

    @Around("execution(* com.library.service.LibraryServiceImpl.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object result = joinPoint.proceed();
        long end = System.nanoTime();
        System.out.println("Executed " + joinPoint.getSignature().getName() +
                " in " + (end - start) / 1_000_000 + " ms");
        return result;
    }
}
