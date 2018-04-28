package pl.akademia.kodu;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Scanner;

public class Registration {
   public static void registration(){
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Login: ");
        user.setLogin(scanner.nextLine());

        System.out.print("Password: ");
        DigestUtils.md5Hex(scanner.nextLine());
        user.setPassword(DigestUtils.md5Hex(scanner.nextLine()));

        System.out.print("Name: ");
        user.setName(scanner.nextLine());

        System.out.print("Surname: ");
        user.setSurname(scanner.nextLine());

        DBConnection.connect();
        DBConnection.insertUser(user);
    }
}
