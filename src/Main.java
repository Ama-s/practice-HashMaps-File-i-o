import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Map<Long, String> contacts = new HashMap<>();

        contacts.put(8140560540L, "Deborah");
        contacts.put(8060519492L, "Mom");
        contacts.put(7038178613L, "Roseline");
        contacts.put(8168230633L, "Gift");
        contacts.put(504343493L, "Fred");

        contacts.forEach((number, name) -> System.out.println("Telephone number: " + number + " Contact name: " + name));

        //one method
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("Charlie", "charlie@emailserver.com", "57575757"));
        clients.add(new Client("Heidy", "heidy@emailserver.com", "78934510"));
        clients.add(new Client("James", "james@emailserver.com", "46374637"));
        clients.add(new Client("Gill", "gill@emailserver.com", "02934356"));

        // Serializable
        try (ObjectOutputStream saveContacts = new ObjectOutputStream(new FileOutputStream("client_info_backup.txt"))) {
            saveContacts.writeObject(clients);
        }

        // Deserialize
        try (ObjectInputStream restoring = new ObjectInputStream(new FileInputStream("client_info_backup.txt"))) {
            List<Client> restoredClients = (List<Client>) restoring.readObject();

            // Print all the contacts.
            for (Client client : restoredClients) {
                System.out.println(client);
            }
        } catch (EOFException e) {
            System.out.println("Reached end of file unexpectedly: " + e.getMessage());
        }
    }
}
