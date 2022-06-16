package lesson1.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int id = 1;
//        User u = new User(id++);
//        User u1 = new User(id);
//        User u2 = new User(id++);
//        User u3 = new User(id++);
//        User u4 = new User(id++);
//        ArrayList<User> list = new ArrayList<>();
//        list.add(u);
//        list.add(u1);
//        list.add(u2);
//        list.add(u3);
//        list.add(u4);
        Key k = new Key("Minh", 20);
        Key k1 = new Key("Minh1", 21);
        Key k2 = new Key("Minh2", 22);
        Key k3 = new Key("Minh", 25);
        Key k4 = new Key("Minh", 20);

        ArrayList<Key> list = new ArrayList<>();
        // add elements quicker and return list;
        List<Key> list2 = Arrays.asList(k, k1, k2, k3, k4);
        System.out.println("aslist");
        list2.forEach(h -> System.out.println(h.toString()));
        list.add(k);
        list.add(k1);
        list.add(k2);
        list.add(k3);
        list.add(k4);
        // distinct: return unique values
        int count = (int) list.stream().distinct().count();
        System.out.println(count);
        // anyMatch return true if one in list is true;
        // allMatch return true if all in list is true;
        //noneMatch return true if none in list is true;
        boolean isCheck = list.stream().anyMatch(Key -> list.contains(k1));
        System.out.println(isCheck);
        // filter: return list which filtered
        List<Key> listFilter = list.stream().filter(Key -> Key.getAge() > 21).collect(Collectors.toList());
        listFilter.forEach(key -> System.out.println(key.toString()));
        Stream<Key> listFilterStream = list.stream().filter(Key -> Key.getAge() > 20);
        listFilterStream.forEach(key -> System.out.println(key.toString()));
        //mapping

        //reduce: include 2 parameters: initial values and function ->
        List<Integer> listReduce = Arrays.asList(3, 5, 6);
        int reduced = listReduce.stream().reduce(20, (a, b) -> a + b);
        System.out.println("Reduced: " + reduced);
        // create list user
        List<User> listUser = Arrays.asList(new User(1), new User(2), new User(3), new User(4));
        // groupby: similar group by in sql, return 1 map with key = first paramater and value = collecion as list or set

        Map<Key, List<User>> keys = listUser.stream().collect(Collectors.groupingBy(h -> new Key(h.getName(), h.getAge())));
        System.out.println("Danh sach luu tru theo key object");
        keys.forEach((h, v) -> {
            System.out.println(h + " : " + v);
        });

//      filter similar to where in sql and groupingby similar to group by
        Map<Integer, List<Key>> collectKeys = list.stream().
                filter(in -> in.getAge() > 20).
                collect(Collectors.groupingBy(in -> in.getAge()));
        collectKeys.forEach((h, v) -> System.out.println(v));

        //takewhile use to break foreach
        System.out.println("takewhile");

        list.stream().takeWhile(u -> u.getAge() % 2 != 0).forEach(u -> System.out.println(u.toString()));
//        System.out.println("don't use takewhile");
//        list.stream().forEach(u -> {
//            if(u.getAge()%2 !=2)
//                System.out.println(u.toString());
//        });
    }
}
