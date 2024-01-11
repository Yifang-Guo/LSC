package com.fangit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Yifang
 * @version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateLog {
    private Integer id; // id
    private Integer operateUser; //operator id
    private LocalDateTime operateTime;
    private String className;
    private String methodName;
    private String methodParams;
    private String returnValue;
    private long costTime;
}
