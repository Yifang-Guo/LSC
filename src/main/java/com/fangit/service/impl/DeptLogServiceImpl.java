package com.fangit.service.impl;

import com.fangit.mapper.DeptLogMapper;
import com.fangit.pojo.DeptLog;
import com.fangit.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yifang
 * @version 1.0
 **/
@Service
public class DeptLogServiceImpl implements DeptLogService {
    @Autowired
    private DeptLogMapper deptLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.inset(deptLog);
    }
}
