package com.fangit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Yifang
 * @version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private Short gender; //sex , 1 male, 2 female
    private String image;
    private Short job; //job position, 1 lecturer , 2 assistant professor , 3 admin manager, 4 edu manager , 5 consultant
    private LocalDate entryDate;
    private Integer deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
