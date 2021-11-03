package com.javaboy.vhr.service.impl;

import com.javaboy.vhr.entity.Nation;
import com.javaboy.vhr.dao.NationDao;
import com.javaboy.vhr.service.NationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Nation)表服务实现类
 *
 * @author makejava
 * @since 2020-07-14 10:54:33
 */
@Service
public class NationServiceImpl implements NationService {
    @Autowired
    private NationDao nationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Nation queryById(Integer id) {
        return this.nationDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Nation> queryAll() {
        return this.nationDao.queryAll(new Nation());
    }


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Nation> queryAllByLimit(int offset, int limit) {
        return this.nationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param nation 实例对象
     * @return 实例对象
     */
    @Override
    public Nation insert(Nation nation) {
        this.nationDao.insert(nation);
        return nation;
    }

    /**
     * 修改数据
     *
     * @param nation 实例对象
     * @return 实例对象
     */
    @Override
    public Nation update(Nation nation) {
        this.nationDao.update(nation);
        return this.queryById(nation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.nationDao.deleteById(id) > 0;
    }
}