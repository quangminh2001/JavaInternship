package lesson1;

import java.util.Comparator;

public class Key {
    private String name;
    private int age;

    public Key() {
    }

    public Key(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        Key key = (Key) obj;
        return this.name.equals(key.getName()) && this.age == key.getAge();
    }

    @Override
    public int hashCode() {
        String number = "" + age;
        return (name + age).hashCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Key{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
