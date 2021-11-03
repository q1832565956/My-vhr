package com.javaboy.vhr.dao;

import com.javaboy.vhr.entity.Menu;
import com.javaboy.vhr.entity.Role;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Menu)表数据库访问层
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
public interface MenuDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Menu queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Menu> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param menu 实例对象
     * @return 对象列表
     */
    List<Menu> queryAll(Menu menu);

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 影响行数
     */
    int insert(Menu menu);

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 影响行数
     */
    int update(Menu menu);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Menu> getMenusId(Integer hrId);

    List<Menu> getRoles();


    /**
     * 获取已启用的资源树
     * @return
     */
    List<Menu> getTreeMenu();

    /**
     * 根据角色id 获取拥有的权限id
     * @param rid
     * @return
     */
    List<Integer> getMenusByRid(Integer rid);
}