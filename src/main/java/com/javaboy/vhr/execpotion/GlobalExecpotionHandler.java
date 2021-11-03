package com.javaboy.vhr.execpotion;


import com.javaboy.vhr.entity.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class GlobalExecpotionHandler {


    @ExceptionHandler(SQLException.class)
    public RespBean mySQLExecpotion(SQLException e){
        if (e instanceof SQLIntegrityConstraintViolationException){
            return RespBean.error("该数据有外键数据，无法删除！");
        }
        System.out.println(e.fillInStackTrace());
        e.getStackTrace();
        System.out.println(e.getSQLState());
        return RespBean.error("数据库异常，请检查");
    }
}
