package com.javaboy.vhr.controller;

import com.javaboy.vhr.entity.Sysmsg;
import com.javaboy.vhr.service.SysmsgService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Sysmsg)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@RestController
@RequestMapping("sysmsg")
public class SysmsgController {
    /**
     * 服务对象
     */
    @Resource
    private SysmsgService sysmsgService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Sysmsg selectOne(Integer id) {
        return this.sysmsgService.queryById(id);
    }

}