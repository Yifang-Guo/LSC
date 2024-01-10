package com.fangit.controller;

import com.fangit.pojo.Emp;
import com.fangit.pojo.Result;
import com.fangit.service.EmpService;
import com.fangit.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yifang
 * @version 1.0
 **/
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("emp log in: {}", emp);
        Emp e = empService.login(emp);

        //log in successfully, create JWT
        if (e != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("name", e.getName());
            claims.put("username", e.getUsername());
            String jwt = JwtUtils.generateJwt(claims); // JWT contains info of current logged in emp
            return Result.success(jwt);
        }

        //log in failed, return error message
        return Result.error("user name or password is wrong");

    }
}
