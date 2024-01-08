package com.fangit.service;

import com.fangit.pojo.Emp;
import com.fangit.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Yifang
 * @version 1.0
 **/
public interface EmpService {
    PageBean page(Integer page, Integer pageSize, String name, Short gender,  LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);
}
