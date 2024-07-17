import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Define the Client class
class Client implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String phone;

    public Client(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Client [Name=" + name + ", Email=" + email + ", Phone=" + phone + "]";
    }
}