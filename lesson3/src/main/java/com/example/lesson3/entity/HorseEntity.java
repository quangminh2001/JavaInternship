package com.example.lesson3.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Date;
import java.util.List;


@Entity // khai báo cho spring biết đây là 1 entity
@Table(name = "horse")// khai báo tên table ứng với bảng có trong sql
@AllArgsConstructor
@NoArgsConstructor
public class HorseEntity extends BaseEntity{

    @Column // nếu không định nghĩa tên ttrong column thì nó tự nhận tên của thuộc tính
    // nếu đặt tên thì tên phải toàn là chữ thường
    private Date foaled;

    public Date getFoaled() {
        return foaled;
    }

    public void setFoaled(Date foaled) {
        this.foaled = foaled;
    }

    @OneToMany(mappedBy = "horse")
    List<HorseAccount> horseAccounts;

    @Override
    public String toString() {
        return "HorseEntity{" +
                "foaled=" + foaled +
                '}';
    }
}
