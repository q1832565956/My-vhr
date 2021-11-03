package com.javaboy.vhr.service.impl;

import com.javaboy.vhr.entity.Msgcontent;
import com.javaboy.vhr.dao.MsgcontentDao;
import com.javaboy.vhr.service.MsgcontentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Msgcontent)表服务实现类
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@Service
public class MsgcontentServiceImpl implements MsgcontentService {
    @Autowired
    private MsgcontentDao msgcontentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Msgcontent queryById(Integer id) {
        return this.msgcontentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Msgcontent> queryAllByLimit(int offset, int limit) {
        return this.msgcontentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param msgcontent 实例对象
     * @return 实例对象
     */
    @Override
    public Msgcontent insert(Msgcontent msgcontent) {
        this.msgcontentDao.insert(msgcontent);
        return msgcontent;
    }

    /**
     * 修改数据
     *
     * @param msgcontent 实例对象
     * @return 实例对象
     */
    @Override
    public Msgcontent update(Msgcontent msgcontent) {
        this.msgcontentDao.update(msgcontent);
        return this.queryById(msgcontent.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.msgcontentDao.deleteById(id) > 0;
    }
}