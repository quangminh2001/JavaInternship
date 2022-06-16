package lesson1.java8.comparing;

import java.util.ArrayList;
import java.util.Comparator;

public class Main {


    public static void main(String[] args) {
        int id = 1;
        User user = new User(id);
        User user1 = new User(id++);
        User user2 = new User(id++);
        User user3 = new User(id++);
        User user4 = new User(id++);
        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.sort(Comparator.comparing(User::getAge).thenComparing(User::getName).reversed());
        users.forEach(u -> {
            System.out.println(u.toString());
        });
    }
}
