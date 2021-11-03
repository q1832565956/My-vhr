package com.javaboy.vhr.controller.sys.sysBasic;

import com.javaboy.vhr.entity.Hr;
import com.javaboy.vhr.entity.RespBean;
import com.javaboy.vhr.entity.Role;
import com.javaboy.vhr.service.HrService;
import com.javaboy.vhr.service.RoleService;
import com.javaboy.vhr.utils.HrUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Hr)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@RestController
@RequestMapping("/system/operator/")
public class HrController {
    /**
     * 服务对象
     */
    @Resource
    private HrService hrService;

    @Resource
    private RoleService roleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Hr selectOne(Integer id) {
        return this.hrService.queryById(id);
    }


    @GetMapping("/manager/hello")
    public Object hello1(){
        return "hello manager";
    }

    @GetMapping("/personnel/hello")
    public Object hello2(){
        return "hello personnel";
    }

    @GetMapping("/recruiter/hello")
    public Object hello3(){
        return "hello recruiter";
    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr){
        Hr uhr = hrService.update(hr);
        if (uhr!=null){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @PutMapping("/hrrole")
    public RespBean updateHrRole(Integer hrid,Integer[] rid){
        try {
            hrService.updateHrRole(hrid, rid);
            return RespBean.ok("更新成功！");
        }catch (Exception e){
            return RespBean.ok("更新失败，系统异常！");
        }
    }

    @GetMapping("/hr")
    public List<Hr> getListHrs(String name){
        return  hrService.getListHrs(name);
    }


    @GetMapping("/role")
    public  List<Role> getListRoles(){
        return roleService.getAll();

    }

    @DeleteMapping("/{id}")
    public  RespBean delteByHr(@PathVariable Integer id){
        boolean b = hrService.deleteById(id);
        if (b){
            return RespBean.ok("删除成功！");
        }
        return  RespBean.error("删除失败！");
    }
}