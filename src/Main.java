import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Long, String> contacts = new HashMap<>();

        contacts.put(8140560540L, "Deborah");
        contacts.put(8060519492L, "Mom");
        contacts.put(7038178613L, "Roseline");
        contacts.put(8168230633L, "Gift");
        contacts.put(8033438491L, "Dad");

        contacts.forEach((number, name) -> System.out.println("Telephone number: " + number + " Contact name: " + name));
        BoundedClass<Integer> boundedClass = new BoundedClass<>(123);
        boundedClass.display();
    }
}