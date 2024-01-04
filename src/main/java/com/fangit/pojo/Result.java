package com.fangit.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Yifang
 * @version 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Integer code;//response code，1 success; 0 fail
    private String msg;  //response message, description
    private Object data; //response data

    //insert delete update success
    public static Result success(){
        return new Result(1,"success",null);
    }
    //query success
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
    //fail
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
