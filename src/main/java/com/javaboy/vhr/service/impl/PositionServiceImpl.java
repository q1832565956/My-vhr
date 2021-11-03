package com.javaboy.vhr.service.impl;

import com.javaboy.vhr.entity.Position;
import com.javaboy.vhr.dao.PositionDao;
import com.javaboy.vhr.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Position)表服务实现类
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    private PositionDao positionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Position queryById(Integer id) {
        return this.positionDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Position> queryAllByLimit(int offset, int limit) {
        return this.positionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 查询所有数据
     *
     * @return 实例对象
     */
    @Override
    public List<Position> queryAll() {
        return this.positionDao.queryAll(new Position());
    }

    /**
     * 新增数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    @Override
    public Position insert(Position position) {
        position.setCreatedate(new Date());
        position.setEnabled(true);
        this.positionDao.insert(position);
        return position;
    }

    /**
     * 修改数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    @Override
    public Position update(Position position) {
        this.positionDao.update(position);
        return this.queryById(position.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.positionDao.deleteById(id) > 0;
    }

    @Override
    public List<Position> getAll() {
        return this.positionDao.getAll();
    }

    @Override
    public boolean deleteAll(List<Position> positions) {

        return this.positionDao.deleteAll(positions);
    }
}