package com.example.lesson3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;


@Entity // khai báo cho spring biết đây là 1 entity
@Table(name = "horse")// khai báo tên table ứng với bảng có trong sql
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

    @Override
    public String toString() {
        return "HorseEntity{" +
                "foaled=" + foaled +
                '}';
    }
}
