package com.javaboy.vhr.service.impl;

import com.javaboy.vhr.dao.HrRoleDao;
import com.javaboy.vhr.dao.RoleDao;
import com.javaboy.vhr.entity.Hr;
import com.javaboy.vhr.dao.HrDao;
import com.javaboy.vhr.entity.RespBean;
import com.javaboy.vhr.entity.Role;
import com.javaboy.vhr.service.HrService;
import com.javaboy.vhr.utils.HrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Hr)表服务实现类
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@Service
public class HrServiceImpl implements HrService, UserDetailsService {
    @Autowired
    private HrDao hrDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private HrRoleDao hrRoleDao;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Hr queryById(Integer id) {
        return this.hrDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Hr> queryAllByLimit(int offset, int limit) {
        return this.hrDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param hr 实例对象
     * @return 实例对象
     */
    @Override
    public Hr insert(Hr hr) {
        this.hrDao.insert(hr);
        return hr;
    }

    /**
     * 修改数据
     *
     * @param hr 实例对象
     * @return 实例对象
     */
    @Override
    public Hr update(Hr hr) {
        this.hrDao.update(hr);
        return this.queryById(hr.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.hrDao.deleteById(id) > 0;
    }

    /**
     * 根据 hrid 左连接查询role，hr_role ,and name！="" 模糊查询hr
     * @param name
     * @return
     */
    @Override
    public List<Hr> getListHrs(String name) {
        Hr currentHr = HrUtil.getCurrentHr();
        return hrDao.getListHrs(currentHr.getId(),"%" + name + "%");
    }

    @Override
    public void updateHrRole(Integer hrid, Integer[] rid) {
        hrRoleDao.deleteByHrid(hrid);
        if (rid != null){
            hrRoleDao.insertHrRole(hrid, rid);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String userName)  {
        Hr hr = hrDao.loadUsername(userName);
        if (hr==null){
            throw  new UsernameNotFoundException("用户不能为空");
        }
        hr.setList(roleDao.loadRolenmae(hr.getId()));
        return hr;
    }






}