package com.javaboy.vhr.service.impl;

import com.javaboy.vhr.entity.Hr;
import com.javaboy.vhr.entity.Menu;
import com.javaboy.vhr.dao.MenuDao;
import com.javaboy.vhr.entity.Role;
import com.javaboy.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Menu)表服务实现类
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Menu queryById(Integer id) {
        return this.menuDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Menu> queryAllByLimit(int offset, int limit) {
        return this.menuDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Menu insert(Menu menu) {
        this.menuDao.insert(menu);
        return menu;
    }

    /**
     * 修改数据
     *
     * @param menu 实例对象
     * @return 实例对象
     */
    @Override
    public Menu update(Menu menu) {
        this.menuDao.update(menu);
        return this.queryById(menu.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.menuDao.deleteById(id) > 0;
    }

    @Override
    public List<Menu> getMenusId() {
        return this.menuDao.getMenusId(((Hr)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    @Override
  //  @Cacheable
    public List<Menu> getRoles(){
        return this.menuDao.getRoles();
    }

    @Override
    public List<Menu> getTreeMenu() {
        return this.menuDao.getTreeMenu();
    }

    @Override
    public List<Integer> getMneusByRid(Integer rid) {
        return this.menuDao.getMenusByRid(rid);
    }
}