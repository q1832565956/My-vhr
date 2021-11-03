package com.javaboy.vhr.controller;

import com.javaboy.vhr.entity.Msgcontent;
import com.javaboy.vhr.service.MsgcontentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Msgcontent)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@RestController
@RequestMapping("msgcontent")
public class MsgcontentController {
    /**
     * 服务对象
     */
    @Resource
    private MsgcontentService msgcontentService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Msgcontent selectOne(Integer id) {
        return this.msgcontentService.queryById(id);
    }

}