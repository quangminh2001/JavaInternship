package com.example.lesson3.entity;


import javax.persistence.*;

@MappedSuperclass // dùng để cho các lớp con biết các thuộc tính được kế thừa xuống vẫn có column
public abstract class BaseEntity {
    @Id // biết đây là khóa chính và không được null
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto tự tăng
    private Long id;
    @Column
    private String name;
    public BaseEntity(){}
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
