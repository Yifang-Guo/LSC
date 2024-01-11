package com.fangit.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author Yifang
 * @version 1.0
 **/
@Slf4j
@Component
@Aspect
public class TimeAspect {

    @Pointcut("execution(* com.fangit.service.*.*(..))")
    private void pt(){}

    @Around("pt()")//pointcut expression
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //record start time
        long begin = System.currentTimeMillis();

        //to original method
        Object result = joinPoint.proceed();

        //record end time
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + " method takes: {}ms", end - begin);

        return result;

    }
}
