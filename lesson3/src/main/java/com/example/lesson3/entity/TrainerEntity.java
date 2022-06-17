package com.example.lesson3.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trainer")
@Getter
@Setter
public class TrainerEntity extends BaseEntity{

//    @OneToMany(mappedBy = "trainer")
//    private List<AccountEntity> accounts;
    //@ontomany 1 nhiều
    //@manytomany nhiều nhiều tạo ra bảng trung gian

    @ManyToOne
    @JoinColumn(name = "accountID",nullable = false)
    private AccountEntity account;

    @Override
    public String toString() {
        return "TrainerEntity{" + "name" + super.getName() + "id="+super.getId()  +
                "account=" + account +
                '}';
    }
}
