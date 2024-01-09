package com.fangit.controller;

import com.fangit.pojo.Emp;
import com.fangit.pojo.PageBean;
import com.fangit.pojo.Result;
import com.fangit.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Yifang
 * @version 1.0
 **/
@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10")Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("query by page, para: {}, {}, {}, {}, {}, {}", page, pageSize, name, gender, begin, end);
        PageBean pageBean = empService.page(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("get emp info by id: {}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("delete operation: {}", ids);
        empService.delete(ids);
        return  Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("add new employee: {}" + emp);
        empService.save(emp);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("update emp info: {}", emp);
        empService.update(emp);
        return Result.success();
    }
}
