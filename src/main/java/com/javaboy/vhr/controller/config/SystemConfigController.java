package com.javaboy.vhr.controller.config;


import com.javaboy.vhr.entity.RespBean;
import com.javaboy.vhr.service.MenuService;
import com.javaboy.vhr.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("system/config")
public class SystemConfigController {

    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    public RespBean GetMenusId(){
        return RespBean.ok("获取成功！",menuService.getMenusId());
    }
}
