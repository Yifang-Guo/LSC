package com.fangit.service.impl;

import com.fangit.mapper.EmpMapper;
import com.fangit.pojo.Emp;
import com.fangit.pojo.PageBean;
import com.fangit.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Yifang
 * @version 1.0
 **/
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;


    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //set page para
        PageHelper.startPage(page, pageSize);
        //query data
        List<Emp> empList = empMapper.list(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        //capsule pageBean
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);

    }

    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public Emp getById(Integer id) {
        return empMapper.getById(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.getByUsernameAndPasswaord(emp);
    }
}
