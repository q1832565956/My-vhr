package com.javaboy.vhr.controller;

import com.javaboy.vhr.entity.Nation;
import com.javaboy.vhr.service.NationService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Nation)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:33
 */
@RestController
@RequestMapping("nation")
public class NationController {
    /**
     * 服务对象
     */
    @Resource
    private NationService nationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Nation selectOne(Integer id) {
        return this.nationService.queryById(id);
    }

}