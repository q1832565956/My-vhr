package com.javaboy.vhr.service.impl;

import com.javaboy.vhr.entity.Employeeremove;
import com.javaboy.vhr.dao.EmployeeremoveDao;
import com.javaboy.vhr.service.EmployeeremoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employeeremove)表服务实现类
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@Service
public class EmployeeremoveServiceImpl implements EmployeeremoveService {
    @Autowired
    private EmployeeremoveDao employeeremoveDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Employeeremove queryById(Integer id) {
        return this.employeeremoveDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Employeeremove> queryAllByLimit(int offset, int limit) {
        return this.employeeremoveDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param employeeremove 实例对象
     * @return 实例对象
     */
    @Override
    public Employeeremove insert(Employeeremove employeeremove) {
        this.employeeremoveDao.insert(employeeremove);
        return employeeremove;
    }

    /**
     * 修改数据
     *
     * @param employeeremove 实例对象
     * @return 实例对象
     */
    @Override
    public Employeeremove update(Employeeremove employeeremove) {
        this.employeeremoveDao.update(employeeremove);
        return this.queryById(employeeremove.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.employeeremoveDao.deleteById(id) > 0;
    }
}