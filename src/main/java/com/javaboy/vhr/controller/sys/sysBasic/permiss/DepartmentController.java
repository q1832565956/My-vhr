package com.javaboy.vhr.controller.sys.sysBasic.permiss;

import com.javaboy.vhr.entity.Department;
import com.javaboy.vhr.entity.RespBean;
import com.javaboy.vhr.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Department)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@RestController
@RequestMapping("/system/basic/department")
public class DepartmentController {
    /**
     * 服务对象
     */
    @Resource
    private DepartmentService departmentService;


    @GetMapping("/")
    public List<Department>  getDepartmentByParentId(){
        return departmentService.getDepartmentByParentId(-1);
    }

    @RequestMapping("/")
    public RespBean addDept(@RequestBody Department dept){
        departmentService.addDept(dept);
        if (dept.getResult()==1) {
            return RespBean.ok("添加成功！",dept);
        }
        return RespBean.error("添加失败");
    }


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Department selectOne(Integer id) {
        return this.departmentService.queryById(id);
    }

}