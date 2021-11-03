package com.javaboy.vhr.controller.sys.sysBasic.joblevel;

import com.javaboy.vhr.entity.Joblevel;
import com.javaboy.vhr.entity.RespBean;
import com.javaboy.vhr.service.JoblevelService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Joblevel)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:33
 */
@RestController
@RequestMapping("/system/basic/job")
public class JoblevelController {
    /**
     * 服务对象
     */
    @Resource
    private JoblevelService joblevelService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Joblevel selectOne(Integer id) {
        return this.joblevelService.queryById(id);
    }

    @GetMapping("/")
    public List<Joblevel> getAll(){
        return joblevelService.getAll();
    }

    @PostMapping("/")
    public RespBean addJOblevel(@RequestBody Joblevel joblevel){
        if(joblevelService.insert(joblevel)!=null){
            return RespBean.ok("保存成功！");
        }
        return RespBean.error("添加失败！");
    }

    @PutMapping("/")
    public RespBean updateJoblevel(@RequestBody Joblevel joblevel){
        if (joblevelService.update(joblevel)!=null){
            return RespBean.ok("修改成功！");
        }
        return RespBean.error("修改失败！");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteJoblevel(@PathVariable Integer id){
        if (joblevelService.deleteById(id)){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/deleteALl")
    public RespBean deleteJoblevels(@RequestBody List<Joblevel> joblevels){
        return joblevelService.deleteAll(joblevels)?RespBean.ok("删除成功！"):RespBean.error("删除失败");
    }
}