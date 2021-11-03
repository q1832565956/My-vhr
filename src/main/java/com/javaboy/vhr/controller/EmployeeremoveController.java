package com.javaboy.vhr.controller;

import com.javaboy.vhr.entity.Employeeremove;
import com.javaboy.vhr.service.EmployeeremoveService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Employeeremove)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@RestController
@RequestMapping("employeeremove")
public class EmployeeremoveController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeremoveService employeeremoveService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Employeeremove selectOne(Integer id) {
        return this.employeeremoveService.queryById(id);
    }

}