package pl.akademia.kodu;

import java.util.Scanner;

public class Login {
    public static void login(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        DBConnection.connect();
        if (DBConnection.authenticate(login, password)){
            System.out.printf("Jest ok");
        } else {
            System.out.println("Error");
        }

    }
}
