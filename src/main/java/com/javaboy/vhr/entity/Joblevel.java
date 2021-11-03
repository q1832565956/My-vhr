package com.javaboy.vhr.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Joblevel)实体类
 *
 * @author makejava
 * @since 2020-07-14 10:54:33
 */
public class Joblevel implements Serializable {
    private static final long serialVersionUID = 472261781957460490L;
    
    private Integer id;
    /**
    * 职称名称
    */
    private String name;
    
    private Object titlelevel;
    
    private Date createdate;
    
    private Object enabled;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getTitlelevel() {
        return titlelevel;
    }

    public void setTitlelevel(Object titlelevel) {
        this.titlelevel = titlelevel;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Object getEnabled() {
        return enabled;
    }

    public void setEnabled(Object enabled) {
        this.enabled = enabled;
    }

}