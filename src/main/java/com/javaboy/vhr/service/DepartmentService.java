package com.javaboy.vhr.service;

import com.javaboy.vhr.entity.Department;
import java.util.List;

/**
 * (Department)表服务接口
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
public interface DepartmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Department queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Department> queryAllByLimit(int offset, int limit);


    /**
     * 查询所有
     * @return
     */
     List<Department> queryAll();
    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    Department insert(Department department);

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    Department update(Department department);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Department> getDepartmentByParentId(Integer pId);

    void addDept(Department dept);
}