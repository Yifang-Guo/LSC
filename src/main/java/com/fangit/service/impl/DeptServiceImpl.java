package com.fangit.service.impl;

import com.fangit.mapper.DeptMapper;
import com.fangit.mapper.EmpMapper;
import com.fangit.pojo.Dept;
import com.fangit.pojo.DeptLog;
import com.fangit.service.DeptLogService;
import com.fangit.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private DeptLogService deptLogService;

    //query department info
    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    //delete department
    @Transactional
    @Override
    public void delete(Integer deptId) {
        try {
            deptMapper.deleteById(deptId);
            empMapper.deleteByDeptId(deptId);
        } finally {
            DeptLog deptLog = new DeptLog();
            deptLog.setCreateTime(LocalDateTime.now());
            deptLog.setDescription("executed delete department operation for Id: " + deptId);
            deptLogService.insert(deptLog);
        }


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
