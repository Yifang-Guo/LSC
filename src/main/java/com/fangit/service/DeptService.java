package com.fangit.service;

import com.fangit.pojo.Dept;

import java.util.List;

/**
 * @author Yifang
 * @version 1.0
 **/
public interface DeptService {
    //query department info
    List<Dept> list();

    //delete department
    void delete(Integer id);

    //add department
    void add(Dept dept);
}
