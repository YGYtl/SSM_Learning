package com.gracepowernode.ov;

public class DemoStudent {
    private Integer id;
    private String name;

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
        return "DemoStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}