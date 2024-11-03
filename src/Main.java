import exeptions.WrongLoginException;
import exeptions.WrongPasswordException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите логин:");
        String login = scanner.next();
        System.out.println(login);
        System.out.print("Введите пароль:");
        String password = scanner.next();
        System.out.print("Подтвердите пароль:");
        String confirmPassword = scanner.next();
        scanner.close();
        try {
            checker(login, password, confirmPassword);
            System.out.println("Успех");
        } catch (WrongLoginException | WrongPasswordException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static void checker(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login.length() > 20 || !login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Login должен содержать в себе только латинские буквы, цифры и знак подчеркивания. Длина не более 20 символов");
        }
        if (password.length() > 20 || !password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Password должен содержать в себе только латинские буквы, цифры и знак подчеркивания. Длина не более 20 символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль не совпадает");
        }
    }
}