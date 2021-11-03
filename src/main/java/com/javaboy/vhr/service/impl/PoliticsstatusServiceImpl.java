package com.javaboy.vhr.service.impl;

import com.javaboy.vhr.entity.Politicsstatus;
import com.javaboy.vhr.dao.PoliticsstatusDao;
import com.javaboy.vhr.service.PoliticsstatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Politicsstatus)表服务实现类
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@Service
public class PoliticsstatusServiceImpl implements PoliticsstatusService {
    @Autowired
    private PoliticsstatusDao politicsstatusDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Politicsstatus queryById(Integer id) {
        return this.politicsstatusDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Politicsstatus> queryAllByLimit(int offset, int limit) {
        return this.politicsstatusDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询所有数据
     *
     * @return 对象列表
     */
    @Override
    public List<Politicsstatus> queryAll() {
        return this.politicsstatusDao.queryAll(new Politicsstatus());
    }

    /**
     * 新增数据
     *
     * @param politicsstatus 实例对象
     * @return 实例对象
     */
    @Override
    public Politicsstatus insert(Politicsstatus politicsstatus) {
        this.politicsstatusDao.insert(politicsstatus);
        return politicsstatus;
    }

    /**
     * 修改数据
     *
     * @param politicsstatus 实例对象
     * @return 实例对象
     */
    @Override
    public Politicsstatus update(Politicsstatus politicsstatus) {
        this.politicsstatusDao.update(politicsstatus);
        return this.queryById(politicsstatus.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.politicsstatusDao.deleteById(id) > 0;
    }
}