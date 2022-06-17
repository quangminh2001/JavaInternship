package com.example.lesson3.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "horseaccount")
public class HorseAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int archive;
// môt account có thể có nhiều trong horseaccount
    @ManyToOne
    @JoinColumn(name = "accountID",nullable = false)
    private AccountEntity account1;
// một horse có thể có nhiều trong horseaccount
    @ManyToOne
    @JoinColumn(name = "horseID",nullable = false)
    private HorseEntity horse;

    public Long getId() {
        return id;
    }
}
