package com.fangit.service.impl;

import com.fangit.mapper.DeptMapper;
import com.fangit.pojo.Dept;
import com.fangit.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Yifang
 * @version 1.0
 **/
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    //query department info
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    //delete department
    @Override
    public void delete(Integer id) {
        deptMapper.deleteById(id);
    }

    //add department
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    @Override
    public void revise(Dept dept) {
        Dept original = getById(dept.getId());
        original.setName(dept.getName());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.revise(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }
}
