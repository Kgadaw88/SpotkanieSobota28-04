package pl.akademia.kodu;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Scanner;

public class Login {
    public static void login(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Password: ");
        String lassword = scanner.nextLine();

        DBConnection.connect();

    }
}
