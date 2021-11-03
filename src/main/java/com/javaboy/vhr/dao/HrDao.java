package com.javaboy.vhr.dao;

import com.javaboy.vhr.entity.Hr;
import com.javaboy.vhr.entity.Role;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Hr)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
public interface HrDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Hr queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Hr> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param hr 实例对象
     * @return 对象列表
     */
    List<Hr> queryAll(Hr hr);

    /**
     * 新增数据
     *
     * @param hr 实例对象
     * @return 影响行数
     */
    int insert(Hr hr);

    /**
     * 修改数据
     *
     * @param hr 实例对象
     * @return 影响行数
     */
    int update(Hr hr);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 通过用户名查询数据
     * @param userName
     * @return
     */
    Hr loadUsername(String userName);

    /**
     * 根据 hrid 左连接查询role，hr_role ,and name！="" 模糊查询hr
     * @param hrid
     * @return
     */
    List<Hr> getListHrs(@Param("hrid") Integer hrid,@Param("name")String name);

}