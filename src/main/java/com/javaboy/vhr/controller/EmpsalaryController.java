package com.javaboy.vhr.controller;

import com.javaboy.vhr.entity.Empsalary;
import com.javaboy.vhr.service.EmpsalaryService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Empsalary)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:33
 */
@RestController
@RequestMapping("empsalary")
public class EmpsalaryController {
    /**
     * 服务对象
     */
    @Resource
    private EmpsalaryService empsalaryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Empsalary selectOne(Integer id) {
        return this.empsalaryService.queryById(id);
    }

}