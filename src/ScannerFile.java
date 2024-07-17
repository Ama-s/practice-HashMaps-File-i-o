import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//Search for Tokens, delimited
public class ScannerFile {
    public static void main(String[] args) throws Exception {
        Scanner input = null;
        //Create a List of Clients. Create all needed classes.

        //Token per Token
        try {
            //Read file clients_info.txt, in every line there is a client information.
            input = new Scanner("clients_info.txt");
            //Each client has name, email and phone. Separated with spaces.

            //Create a Client object and add it to the clients list.
        } finally {
            if (input != null){
                input.close();
            }
        }

        //Serializable 
        ObjectOutputStream savecontants = null;
        try {
            //Save the contacts list object on a file named client_info_backup.txt
        } finally {
            if (savecontants != null){
                savecontants.close();
            }
        }



        //Deserialize

        ObjectInputStream restoring = null;
        try {
            //Restore the Contact List.
            //Print all the contacts.
        } finally {
            if (restoring != null){
                restoring.close();
            }
        }
    }
}