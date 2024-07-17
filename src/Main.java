import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{
        Map<Long, String> contacts = new HashMap<>();

        contacts.put(8140560540L, "Deborah");
        contacts.put(8060519492L, "Mom");
        contacts.put(7038178613L, "Roseline");
        contacts.put(8168230633L, "Gift");
        contacts.put(8033438491L, "Dad");

        contacts.forEach((number, name) -> System.out.println("Telephone number: " + number + " Contact name: " + name));
        BoundedClass<Integer> boundedClass = new BoundedClass<>(123);
        boundedClass.display();


        Scanner input = null;
        List<Client> clients = new ArrayList<>();

        // Token per Token
        try {
            //
            // Read file clients_info.txt, in every line there is a client information.
            FileReader fileReader = new FileReader("clients_info.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            input = new Scanner(bufferedReader);

            // Each client has name, email and phone. Separated with spaces.
            while (input.hasNextLine()) {
                String line = input.nextLine();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter(" ");

                // Create a Client object and add it to the clients list.
                if (lineScanner.hasNext()) {
                    String name = lineScanner.next();
                    String email = lineScanner.next();
                    String phone = lineScanner.next();
                    clients.add(new Client(name, email, phone));
                }
                lineScanner.close();
            }
        } finally {
            if (input != null) {
                input.close();
            }
        }

        // Serializable
        ObjectOutputStream saveContacts = null;
        try {
            // Save the contacts list object on a file named client_info_backup.txt
            saveContacts = new ObjectOutputStream(new FileOutputStream("client_info_backup.txt"));
            saveContacts.writeObject(clients);
        } finally {
            if (saveContacts != null) {
                saveContacts.close();
            }
        }

        // Deserialize
        ObjectInputStream restoring = null;
        try {
            // Restore the Contact List.
            restoring = new ObjectInputStream(new FileInputStream("client_info_backup.txt"));
            List<Client> restoredClients = (List<Client>) restoring.readObject();

            // Print all the contacts.
            for (Client client : restoredClients) {
                System.out.println(client);
            }
        } finally {
            if (restoring != null) {
                restoring.close();
            }
        }
    }
}