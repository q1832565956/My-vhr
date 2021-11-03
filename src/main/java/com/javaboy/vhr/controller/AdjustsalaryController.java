package com.javaboy.vhr.controller;

import com.javaboy.vhr.entity.Adjustsalary;
import com.javaboy.vhr.service.AdjustsalaryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Adjustsalary)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@RestController
@RequestMapping("adjustsalary")
public class AdjustsalaryController {
    /**
     * 服务对象
     */
    @Resource
    private AdjustsalaryService adjustsalaryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Adjustsalary selectOne(Integer id) {
        return this.adjustsalaryService.queryById(id);
    }

}