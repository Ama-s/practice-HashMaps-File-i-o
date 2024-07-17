public class ScannerFile {
    public static void main(String[] args) throws Exception {
        Scanner input = null;
        List<Client> clients = new ArrayList<>();

        // Token per Token
        try {
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