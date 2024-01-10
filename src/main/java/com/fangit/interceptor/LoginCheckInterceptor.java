package com.fangit.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.fangit.pojo.Result;
import com.fangit.utils.JwtUtils;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Yifang
 * @version 1.0
 **/
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//return false, do not proceed
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //get request url
        String url = request.getRequestURL().toString();
        log.info("url of request: {}", url);

        //check if the url contains "login", if yes, proceed
        if (url.contains("login")){
            log.info("login operation, proceed");
            return true;
        }

        //get JWT token from request header
        String jwt = request.getHeader("token");

        //check if jwt exits, if not, return error message
        if(!StringUtils.hasLength(jwt)){
            log.info("token doesn't exist, return not logged in message");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        //decode token, if decode fails, return error message
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("decode jwt fails, return error message");
            Result error = Result.error("NOT_LOGIN");
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }

        log.info("valid jwt, proceed");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
