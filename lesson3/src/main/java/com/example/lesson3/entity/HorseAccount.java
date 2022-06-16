package com.example.lesson3.entity;

import javax.persistence.*;

@Entity
@Table(name = "horseaccount")
public class HorseAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int archive;

//    @ManyToOne
//    @JoinColumn(name = "accountID",nullable = false)
//    private AccountEntity account;

//    @OneToMany(mappedBy = "")

    public Long getId() {
        return id;
    }
}
