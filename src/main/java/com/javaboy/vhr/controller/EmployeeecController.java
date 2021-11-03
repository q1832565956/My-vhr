package com.javaboy.vhr.controller;

import com.javaboy.vhr.entity.Employeeec;
import com.javaboy.vhr.service.EmployeeecService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Employeeec)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:33
 */
@RestController
@RequestMapping("employeeec")
public class EmployeeecController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeecService employeeecService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Employeeec selectOne(Integer id) {
        return this.employeeecService.queryById(id);
    }

}