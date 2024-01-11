package com.fangit.mapper;

import com.fangit.pojo.DeptLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Yifang
 * @version 1.0
 **/
@Mapper
public interface DeptLogMapper {

    @Insert("insert into dept_log(create_time, description) values(#{createTime}, #{description})")
    void inset(DeptLog log);

}
