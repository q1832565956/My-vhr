package com.javaboy.vhr.controller.sys.sysBasic.permiss;

import com.javaboy.vhr.entity.RespBean;
import com.javaboy.vhr.entity.Role;
import com.javaboy.vhr.service.RoleService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:33
 */
@RestController
@RequestMapping("/system/basic/role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Role selectOne(Integer id) {
        return this.roleService.queryById(id);
    }

    @GetMapping("/")
    public List<Role> getAll(){
        return this.roleService.getAll();
    }

    @PostMapping("/")
    public RespBean insert(@RequestBody Role role){
        if(this.roleService.insert(role)!=null){
            return RespBean.ok("新增成功");
        }
        return RespBean.error("新增失败");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteRole(@PathVariable Integer id){

        if (this.roleService.deleteById(id)){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

}