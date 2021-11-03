package com.javaboy.vhr.controller.emp.basic;

import com.javaboy.vhr.entity.*;
import com.javaboy.vhr.service.*;
import javafx.beans.DefaultProperty;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employee)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@RestController
@RequestMapping("/emp/basic")
public class EmployeeController {
    /**
     * 服务对象
     */
    @Resource
    private EmployeeService employeeService;

    @Resource
    private JoblevelService joblevelService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PositionService positionService;

    @Resource
    private PoliticsstatusService politicsstatusService;

    @Resource
    private NationService nationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Employee selectOne(Integer id) {
        return this.employeeService.queryById(id);
    }


    @GetMapping("/")
    public List<Employee> selectAll(String eName, @RequestParam(defaultValue = "1") Long page, @RequestParam(defaultValue = "10") Long pageSize){
        return employeeService.getAll(eName,page,pageSize);
    }

    @GetMapping("/total")
    public Long getTotal(String eName){

        return employeeService.getTotal(eName);

    }

    @GetMapping("/job")
    public List<Joblevel> getJoblevels(){
        return joblevelService.getAll();

    }

    @GetMapping("/pos")
    public List<Position> getPositions(){
        return positionService.getAll();

    }

    @GetMapping("/nation")
    public List<Nation> getNations(){
        return nationService.queryAll();

    }

    @GetMapping("/dept")
    public List<Department> getDepartments(){
        return departmentService.queryAll();

    }

    @GetMapping("/politic")
    public List<Politicsstatus> getPoliticsStatus(){
        return politicsstatusService.queryAll();

    }
}