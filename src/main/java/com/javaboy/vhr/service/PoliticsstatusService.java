package com.javaboy.vhr.service;

import com.javaboy.vhr.entity.Politicsstatus;
import java.util.List;

/**
 * (Politicsstatus)表服务接口
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
public interface PoliticsstatusService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Politicsstatus queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Politicsstatus> queryAllByLimit(int offset, int limit);

    List<Politicsstatus> queryAll();
    /**
     * 新增数据
     *
     * @param politicsstatus 实例对象
     * @return 实例对象
     */
    Politicsstatus insert(Politicsstatus politicsstatus);

    /**
     * 修改数据
     *
     * @param politicsstatus 实例对象
     * @return 实例对象
     */
    Politicsstatus update(Politicsstatus politicsstatus);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}