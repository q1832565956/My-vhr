package com.javaboy.vhr.service;

import com.javaboy.vhr.entity.Position;
import java.util.List;

/**
 * (Position)表服务接口
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
public interface PositionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Position queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Position> queryAllByLimit(int offset, int limit);

    List<Position> queryAll();

    /**
     * 新增数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    Position insert(Position position);

    /**
     * 修改数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    Position update(Position position);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Position> getAll();

    boolean deleteAll(List<Position> positions);
}