package lesson1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void writeToFile(ArrayList<User> list) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        System.out.print("Enter name file: ");
        String name = sc.nextLine();
        try {
            fos = new FileOutputStream(name + ".txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            System.out.println("Write to file successful");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // if fos or oss is null, they will throw exception
            // should be try catch when closing oos and fos
            // find issue...
            if (oos != null) {
                oos.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }

    //sort by name use
    public static void sortByName(ArrayList<User> list) {
        list.sort(Comparator.comparing(User::getName).reversed());
    }

    public static void displayList(ArrayList<User> list) {
        list.forEach(System.out::println);
    }

    public static Set<String> collectNameUser(ArrayList<User> list) {
        return list.stream().map(user -> user.getName()).collect(Collectors.toSet());
    }

    public static int countMale(ArrayList<User> list) {
        Malelfemale male = Malelfemale.valueOf("Male");
        return (int) list.stream().filter(user -> user.getSex().equals(male)).count();
    }

    public static Map<String, List<User>> collectUserSameName(ArrayList<User> list) {
        return list.stream().collect(Collectors.groupingBy(user -> user.getName(), Collectors.toList()));
    }

    public static Map<Key, List<User>> collectUserSameNameAndAge(ArrayList<User> list) {
        return list.stream().collect(Collectors.groupingBy(u -> new Key(u.getName(), u.getAge()), Collectors.toList()));
    }

    public static void main(String[] args) throws IOException {
        ArrayList<User> listUsers = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            User user = new User(i + 1);
            System.out.println(user.toString());
            listUsers.add(user);
        }

        ArrayList<String> list1 = new ArrayList<>(collectNameUser(listUsers));
        do {
            System.out.println("\n-----------------JavaCore-----------------------");
            System.out.println("\t1. Write to file");
            System.out.println("\t2. Collect all name in list user");
            System.out.println("\t3. Sort user by name");
            System.out.println("\t4. Count male and female in list");
            System.out.println("\t5. Collect user same name in list ");
            System.out.println("\t6. Collect user same name and age in list");
            System.out.println("\t0. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    writeToFile(listUsers);
                    break;
                case 2:
                    list1.forEach(name -> {
                        System.out.print("\t" + name);
                    });
                    break;
                case 3:
                    System.out.println("\n----------------------------------------------------------");
                    sortByName(listUsers);
                    displayList(listUsers);
                    break;
                case 4:
                    System.out.println("Male: " + countMale(listUsers));
                    System.out.println("Female: " + (listUsers.stream().count() - countMale(listUsers)));
                    break;
                case 5:
                    System.out.println("\n--------------------------------------------------------");
                    Map<String, List<User>> listHashMapSameName = collectUserSameName(listUsers);
                    listHashMapSameName.forEach((k, v) -> {
                        System.out.println(k + " : " + v);
                    });
                    break;
                case 6:
                    System.out.println("\n----------------------------------------------------------------------");
                    Map<Key, List<User>> listHashMapSameNameAndAge = collectUserSameNameAndAge(listUsers);
                    listHashMapSameNameAndAge.forEach((k, v) -> {
                        System.out.println(k.toString() + " : " + v);
                    });
                    break;
                case 0:
                    System.out.println("Exited");
                    System.exit(0);
                default:
                    System.out.println("Your choice failt");
                    break;
            }
        } while (true);
    }
}
