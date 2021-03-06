package com.javaboy.vhr.service;

import com.javaboy.vhr.entity.Employeeec;
import java.util.List;

/**
 * (Employeeec)表服务接口
 *
 * @author makejava
 * @since 2020-07-14 10:54:33
 */
public interface EmployeeecService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Employeeec queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Employeeec> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param employeeec 实例对象
     * @return 实例对象
     */
    Employeeec insert(Employeeec employeeec);

    /**
     * 修改数据
     *
     * @param employeeec 实例对象
     * @return 实例对象
     */
    Employeeec update(Employeeec employeeec);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}