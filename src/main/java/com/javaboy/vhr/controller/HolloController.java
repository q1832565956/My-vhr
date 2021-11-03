package com.javaboy.vhr.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolloController {


    @GetMapping("/employee/basic/hello")
    public Object hello1(){
        return "/employee/basic/hello";
    }

    @GetMapping("/employee/advanced/hello")
    public Object hello2(){
        return "/employee/advanced/hello";
    }

}
