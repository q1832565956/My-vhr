package com.javaboy.vhr.controller;

import com.javaboy.vhr.entity.Politicsstatus;
import com.javaboy.vhr.service.PoliticsstatusService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Politicsstatus)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@RestController
@RequestMapping("politicsstatus")
public class PoliticsstatusController {
    /**
     * 服务对象
     */
    @Resource
    private PoliticsstatusService politicsstatusService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Politicsstatus selectOne(Integer id) {
        return this.politicsstatusService.queryById(id);
    }

}