package com.javaboy.vhr.controller;

import com.javaboy.vhr.entity.Employeetrain;
import com.javaboy.vhr.service.EmployeetrainService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Employeetrain)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@RestController
@RequestMapping("employeetrain")
public class EmployeetrainController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeetrainService employeetrainService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Employeetrain selectOne(Integer id) {
        return this.employeetrainService.queryById(id);
    }

}