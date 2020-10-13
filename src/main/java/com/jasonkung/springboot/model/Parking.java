package com.jasonkung.springboot.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//表示是一個對應到 Database Table 的 Object。
@Entity
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(columnDefinition = "VARCHAR", length = 100)
    private String name;
    @NotNull
    @Column(columnDefinition = "INTEGER default 0")
    private Integer space;

    public Integer getSpace() {
        return space;
    }

    public void setSpace(Integer space) {
        this.space = space;
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


    @Override
    public String toString() {
        return "Name: " + this.name + ", Space: " + this.space;
    }

}