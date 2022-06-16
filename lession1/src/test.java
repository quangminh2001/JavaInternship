import java.util.*;

public class test {
    public static void main(String[] args) {
        Map<Key, String> listMap = new HashMap<>();
        listMap.put(new Key("Minh", 20), "Hello");
        listMap.put(new Key("Minh", 20), "Hello");
        listMap.put(new Key("Minh", 27), "Hello");
        listMap.put(new Key("Minh", 28), "Hello");
        listMap.put(new Key("MinhNguyne", 20), "Hello");
        listMap.forEach((k, v) -> {
            System.out.println(k.toString() + " + " + v);
        });
    }
}
