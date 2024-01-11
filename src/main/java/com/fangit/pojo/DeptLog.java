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
@AllArgsConstructor
@NoArgsConstructor
public class DeptLog {
    private Integer id;
    private LocalDateTime createTime;

    private String description;
}
