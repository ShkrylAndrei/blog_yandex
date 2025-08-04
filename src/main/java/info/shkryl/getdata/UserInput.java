package info.shkryl.getdata;

import java.util.Scanner;

public class UserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ваше имя: ");
        String name = scanner.nextLine(); // с пробелами: "Иван Петров"

        System.out.print("Введите возраст: ");
        int age = scanner.nextInt();

        System.out.println("Привет, " + name + "! Тебе " + age + " лет.");

        scanner.close(); // важно!
    }
}
