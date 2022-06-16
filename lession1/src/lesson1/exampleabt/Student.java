package lesson1.exampleabt;

import java.util.Scanner;

public class Student extends Person {

    private int id;

    public Student() {

    }

    Scanner sc = new Scanner(System.in);

    public Student(String name, String address, String numberPhone, int id) {
        super(name, address, numberPhone);
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numberPhone='" + numberPhone + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        System.out.print("Input id: ");
        id = Integer.parseInt(sc.nextLine());
        System.out.print("Input name: ");
        name = sc.nextLine();
        System.out.print("Input address: ");
        address = sc.nextLine();
        System.out.print("Input phone number: ");
        numberPhone = sc.nextLine();
    }
}
