package com.javaboy.vhr.service.impl;

import com.javaboy.vhr.entity.Adjustsalary;
import com.javaboy.vhr.dao.AdjustsalaryDao;
import com.javaboy.vhr.service.AdjustsalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Adjustsalary)表服务实现类
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@Service
public class AdjustsalaryServiceImpl implements AdjustsalaryService {
    @Autowired
    private AdjustsalaryDao adjustsalaryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Adjustsalary queryById(Integer id) {
        return this.adjustsalaryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Adjustsalary> queryAllByLimit(int offset, int limit) {
        return this.adjustsalaryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param adjustsalary 实例对象
     * @return 实例对象
     */
    @Override
    public Adjustsalary insert(Adjustsalary adjustsalary) {
        this.adjustsalaryDao.insert(adjustsalary);
        return adjustsalary;
    }

    /**
     * 修改数据
     *
     * @param adjustsalary 实例对象
     * @return 实例对象
     */
    @Override
    public Adjustsalary update(Adjustsalary adjustsalary) {
        this.adjustsalaryDao.update(adjustsalary);
        return this.queryById(adjustsalary.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.adjustsalaryDao.deleteById(id) > 0;
    }
}