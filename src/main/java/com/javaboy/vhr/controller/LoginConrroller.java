package com.javaboy.vhr.controller;


import com.javaboy.vhr.entity.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginConrroller {

    @GetMapping("/login")
    public RespBean Login(){
        return RespBean.error("未找到登录界面");
    }
}

