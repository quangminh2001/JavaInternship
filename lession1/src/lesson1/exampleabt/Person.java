package lesson1.exampleabt;

public abstract class Person {
    protected String name;
    protected String address;
    protected String numberPhone;

    public Person() {

    }

    public Person(String name, String address, String numberPhone) {
        this.name = name;
        this.address = address;
        this.numberPhone = numberPhone;
    }

    public abstract void inputInfo();
}
