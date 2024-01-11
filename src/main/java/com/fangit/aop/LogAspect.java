package com.fangit.aop;

import com.alibaba.fastjson.JSONObject;
import com.fangit.mapper.OperateLogMapper;
import com.fangit.pojo.OperateLog;
import com.fangit.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * @author Yifang
 * @version 1.0
 **/
@Component
@Aspect
@Slf4j
public class LogAspect {
    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.fangit.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

        //operator id
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);
        Integer operateUser = (Integer) claims.get("id");

        //operate time
        LocalDateTime operateTime = LocalDateTime.now();

        //operate class name
        String className = joinPoint.getTarget().getClass().getName();

        //operate method name
        String methodName = joinPoint.getSignature().getName();

        //operate method params
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        long begin = System.currentTimeMillis();
        //return value
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        String returnValue = JSONObject.toJSONString(result);

        //operate time
        Long costTime = end - begin;


        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue, costTime);

        operateLogMapper.insert(operateLog);

        log.info("AOP record operate log: {}", log);

        return result;
    }
}
