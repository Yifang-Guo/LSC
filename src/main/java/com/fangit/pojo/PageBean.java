package com.fangit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Yifang
 * @version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    private long total; //total record
    private List rows; //current data info in this page
}
