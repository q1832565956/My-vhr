package com.javaboy.vhr.service.impl;

import com.javaboy.vhr.entity.Sysmsg;
import com.javaboy.vhr.dao.SysmsgDao;
import com.javaboy.vhr.service.SysmsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Sysmsg)表服务实现类
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@Service
public class SysmsgServiceImpl implements SysmsgService {
    @Autowired
    private SysmsgDao sysmsgDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Sysmsg queryById(Integer id) {
        return this.sysmsgDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Sysmsg> queryAllByLimit(int offset, int limit) {
        return this.sysmsgDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysmsg 实例对象
     * @return 实例对象
     */
    @Override
    public Sysmsg insert(Sysmsg sysmsg) {
        this.sysmsgDao.insert(sysmsg);
        return sysmsg;
    }

    /**
     * 修改数据
     *
     * @param sysmsg 实例对象
     * @return 实例对象
     */
    @Override
    public Sysmsg update(Sysmsg sysmsg) {
        this.sysmsgDao.update(sysmsg);
        return this.queryById(sysmsg.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysmsgDao.deleteById(id) > 0;
    }
}