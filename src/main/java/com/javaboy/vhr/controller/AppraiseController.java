package com.javaboy.vhr.controller;

import com.javaboy.vhr.entity.Appraise;
import com.javaboy.vhr.service.AppraiseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Appraise)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@RestController
@RequestMapping("appraise")
public class AppraiseController {
    /**
     * 服务对象
     */
    @Resource
    private AppraiseService appraiseService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Appraise selectOne(Integer id) {
        return this.appraiseService.queryById(id);
    }

}