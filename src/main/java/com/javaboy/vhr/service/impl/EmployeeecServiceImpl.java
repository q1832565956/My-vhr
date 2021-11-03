package com.javaboy.vhr.service.impl;

import com.javaboy.vhr.entity.Employeeec;
import com.javaboy.vhr.dao.EmployeeecDao;
import com.javaboy.vhr.service.EmployeeecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employeeec)表服务实现类
 *
 * @author makejava
 * @since 2020-07-14 10:54:33
 */
@Service
public class EmployeeecServiceImpl implements EmployeeecService {
    @Autowired
    private EmployeeecDao employeeecDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Employeeec queryById(Integer id) {
        return this.employeeecDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Employeeec> queryAllByLimit(int offset, int limit) {
        return this.employeeecDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param employeeec 实例对象
     * @return 实例对象
     */
    @Override
    public Employeeec insert(Employeeec employeeec) {
        this.employeeecDao.insert(employeeec);
        return employeeec;
    }

    /**
     * 修改数据
     *
     * @param employeeec 实例对象
     * @return 实例对象
     */
    @Override
    public Employeeec update(Employeeec employeeec) {
        this.employeeecDao.update(employeeec);
        return this.queryById(employeeec.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.employeeecDao.deleteById(id) > 0;
    }
}