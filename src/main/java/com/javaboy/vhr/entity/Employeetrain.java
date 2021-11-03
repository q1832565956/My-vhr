package com.javaboy.vhr.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Employeetrain)实体类
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
public class Employeetrain implements Serializable {
    private static final long serialVersionUID = 627527357029891363L;
    
    private Integer id;
    /**
    * 员工编号
    */
    private Integer eid;
    /**
    * 培训日期
    */
    private Date traindate;
    /**
    * 培训内容
    */
    private String traincontent;
    /**
    * 备注
    */
    private String remark;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Date getTraindate() {
        return traindate;
    }

    public void setTraindate(Date traindate) {
        this.traindate = traindate;
    }

    public String getTraincontent() {
        return traincontent;
    }

    public void setTraincontent(String traincontent) {
        this.traincontent = traincontent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}