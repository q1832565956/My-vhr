package com.javaboy.vhr.entity;

import java.io.Serializable;

/**
 * (Role)实体类
 *
 * @author makejava
 * @since 2020-07-14 10:54:33
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -98830836168715553L;
    
    private Integer id;
    
    private String name;
    /**
    * 角色名称
    */
    private String namezh;


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

    public String getNamezh() {
        return namezh;
    }

    public void setNamezh(String namezh) {
        this.namezh = namezh;
    }

}