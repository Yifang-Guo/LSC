package com.fangit.controller;

import com.fangit.anno.Log;
import com.fangit.pojo.Dept;
import com.fangit.pojo.Result;
import com.fangit.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Yifang
 * @version 1.0
 **/
@Slf4j//logger
@RestController
@RequestMapping("/depts")
public class DeptController {
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    //@RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list(){
        log.info("query all of the department data");

        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("delete department by id:" + id);
        deptService.delete(id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("add department:" + dept.getName());
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("get department by id: " + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @Log
    @PutMapping
    public Result revise(@RequestBody Dept dept){
        log.info("revise department to name: " + dept.getName());
        deptService.revise(dept);
        return Result.success();
    }

}
