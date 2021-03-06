package com.javaboy.vhr.service.impl;

import com.javaboy.vhr.entity.Joblevel;
import com.javaboy.vhr.dao.JoblevelDao;
import com.javaboy.vhr.service.JoblevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Joblevel)表服务实现类
 *
 * @author makejava
 * @since 2020-07-14 10:54:33
 */
@Service
public class JoblevelServiceImpl implements JoblevelService {
    @Autowired
    private JoblevelDao joblevelDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Joblevel queryById(Integer id) {
        return this.joblevelDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Joblevel> queryAllByLimit(int offset, int limit) {
        return this.joblevelDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    @Override
    public List<Joblevel> queryAll() {
        return this.joblevelDao.queryAll(new Joblevel());
    }

    /**
     * 新增数据
     *
     * @param joblevel 实例对象
     * @return 实例对象
     */
    @Override
    public Joblevel insert(Joblevel joblevel) {
        joblevel.setCreatedate(new Date());
        joblevel.setEnabled(true);
        this.joblevelDao.insert(joblevel);
        return joblevel;
    }

    /**
     * 修改数据
     *
     * @param joblevel 实例对象
     * @return 实例对象
     */
    @Override
    public Joblevel update(Joblevel joblevel) {
        this.joblevelDao.update(joblevel);
        return this.queryById(joblevel.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.joblevelDao.deleteById(id) > 0;
    }

    @Override
    public List<Joblevel> getAll() {
        return this.joblevelDao.queryAll(new Joblevel());
    }

    @Override
    public boolean deleteAll(List<Joblevel> joblevels) {
        return this.joblevelDao.deleteAll(joblevels);
    }

}