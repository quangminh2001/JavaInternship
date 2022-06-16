package com.example.lesson3.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "account")
public class AccountEntity {
    @Id // có hai chức năng 1 là not null 2 là primery key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // dùng để auto tự tăng trong
    private Long id;

    @Column // dùng để cho sql biết khi tác động vào cột nào trong cơ sở dữ liệu
    private String username;
    @Column
    private String password;
    @Column
    private int status;

    public Long getId() {
        return id;
    }
    @OneToMany(mappedBy = "account")
    private List<TrainerEntity> trainer;

    public AccountEntity(Long id) {
        this.id = id;
    }

    public AccountEntity(Long id, String username, String password, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public AccountEntity() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

//    public List<TrainerEntity> getTrainer() {
//        return trainer;
//    }
//
//    public void setTrainer(List<TrainerEntity> trainer) {
//        this.trainer = trainer;
//    }
//    @OneToMany(mappedBy = "")

//    @ManyToOne
//    @JoinColumn(name = "accountID",nullable = false)
//    private TrainerEntity trainer;

    @Override
    public String toString() {
        return "AccountEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", trainer=" + trainer +
                '}';
    }

}
