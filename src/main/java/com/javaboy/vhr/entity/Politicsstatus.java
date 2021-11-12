package com.javaboy.vhr.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * (Politicsstatus)实体类
 *
 * @author makejava
 * @since 2020-07-14 10:54:34
 */
public class Politicsstatus implements Serializable {
    private static final long serialVersionUID = -62513563058109154L;
    
    private Integer id;
    
    private String name;

    public Politicsstatus() {
    }

    public Politicsstatus(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Politicsstatus that = (Politicsstatus) o;
        return name.equals(that.name);
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