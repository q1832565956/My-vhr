package com.javaboy.vhr.service;

import com.javaboy.vhr.entity.Employeetrain;
import java.util.List;

/**
 * (Employeetrain)表服务接口
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
public interface EmployeetrainService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Employeetrain queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Employeetrain> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param employeetrain 实例对象
     * @return 实例对象
     */
    Employeetrain insert(Employeetrain employeetrain);

    /**
     * 修改数据
     *
     * @param employeetrain 实例对象
     * @return 实例对象
     */
    Employeetrain update(Employeetrain employeetrain);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}