package com.javaboy.vhr.controller.sys.sysBasic.permiss;

import com.javaboy.vhr.entity.Menu;
import com.javaboy.vhr.entity.RespBean;
import com.javaboy.vhr.service.MenuRoleService;
import com.javaboy.vhr.service.MenuService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Menu)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@RestController
@RequestMapping("/system/basic/menu")
public class MenuController {
    /**
     * 服务对象
     */
    @Resource
    private MenuService menuService;

    @Resource
    private MenuRoleService menuRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Menu selectOne(Integer id) {
        return this.menuService.queryById(id);
    }


    @GetMapping("/")
    public List<Menu> getTreeMenu(){
        return this.menuService.getTreeMenu();
    }

    @GetMapping("/getMenusById/{rid}")
    public List<Integer> getMenusByRid(@PathVariable Integer rid ){
        return this.menuService.getMneusByRid(rid);

    }

    @PutMapping("/")
    public RespBean doUpdateMenuRole(Integer rid,Integer[] mids){
        Boolean aBoolean = this.menuRoleService.doUpdateMenuRole(rid, mids);
        if (aBoolean){
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}