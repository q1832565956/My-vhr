package com.javaboy.vhr.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * (Nation)实体类
 *
 * @author makejava
 * @since 2020-07-14 10:54:33
 */
public class Nation implements Serializable {
    private static final long serialVersionUID = -21014323397333716L;
    
    private Integer id;
    
    private String name;

    public Nation(String name) {
        this.name = name;
    }

    public Nation() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nation nation = (Nation) o;
        return name.equals(nation.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

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

}