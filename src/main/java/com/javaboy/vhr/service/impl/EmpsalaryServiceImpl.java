package com.javaboy.vhr.service.impl;

import com.javaboy.vhr.entity.Empsalary;
import com.javaboy.vhr.dao.EmpsalaryDao;
import com.javaboy.vhr.service.EmpsalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Empsalary)表服务实现类
 *
 * @author makejava
 * @since 2020-07-14 10:54:33
 */
@Service
public class EmpsalaryServiceImpl implements EmpsalaryService {
    @Autowired
    private EmpsalaryDao empsalaryDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Empsalary queryById(Integer id) {
        return this.empsalaryDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Empsalary> queryAllByLimit(int offset, int limit) {
        return this.empsalaryDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param empsalary 实例对象
     * @return 实例对象
     */
    @Override
    public Empsalary insert(Empsalary empsalary) {
        this.empsalaryDao.insert(empsalary);
        return empsalary;
    }

    /**
     * 修改数据
     *
     * @param empsalary 实例对象
     * @return 实例对象
     */
    @Override
    public Empsalary update(Empsalary empsalary) {
        this.empsalaryDao.update(empsalary);
        return this.queryById(empsalary.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.empsalaryDao.deleteById(id) > 0;
    }
}