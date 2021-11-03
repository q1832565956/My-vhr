package com.javaboy.vhr.controller.sys.sysBasic.position;

import com.javaboy.vhr.entity.Position;
import com.javaboy.vhr.entity.RespBean;
import com.javaboy.vhr.service.PositionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Position)表控制层
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
    /**
     * 服务对象
     */
    @Resource
    private PositionService positionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Position selectOne(Integer id) {
        return this.positionService.queryById(id);
    }

    @GetMapping("/")
    public List<Position> getAll(){
        return positionService.getAll();
    }


    @PostMapping("/")
    public RespBean positionInsert(@RequestBody Position position){
        if (positionService.insert(position)!=null){
            return RespBean.ok("新增成功");
        }
        return RespBean.error("新增失败");
    }

    @PutMapping("/")
    public RespBean positionUpdate(@RequestBody Position position){
        if (positionService.update(position)!=null){
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    public RespBean positionDelete(@PathVariable Integer id){
        if (positionService.deleteById(id)){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/deleteAll")
    public RespBean deleteAll(@RequestBody List<Position> positions){
        if (positionService.deleteAll(positions)){
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}