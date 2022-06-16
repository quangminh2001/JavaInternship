package lesson1.java8.stream;


import lesson1.Malelfemale;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class User implements Serializable {
    private int id;
    private String name;
    private Malelfemale sex;
    private int age;

    public User() {

    }

    public User(int id) {
        this.id = id;
        setName();
        setAge();
        setSex();
    }

    public void setName() {
        List<String> listCharacter = new ArrayList<>();
        listCharacter.add("f");
        listCharacter.add("r");
        listCharacter.add("u");
        listCharacter.add("i");
        listCharacter.add("t");
        Collections.shuffle(listCharacter, new Random());
        this.name = listCharacter.get(0) + listCharacter.get(1) + listCharacter.get(2);
    }

    public String getName() {
        return name;
    }

    public void setSex() {
        Malelfemale[] malelfemale = Malelfemale.values();
        this.sex = malelfemale[(int) (Math.random() * 2)];
    }

    public Malelfemale getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
//        Math.random()*(Max - Min +1) + Min
        this.age = (int) (Math.random() * (4) + 20);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                '}';
    }
}
