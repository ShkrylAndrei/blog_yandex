package info.shkryl.controlStructures;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Начать игру");
            System.out.println("2. Настройки");
            System.out.println("3. Выход");
            System.out.print("Выберите: ");
            choice = scanner.nextInt();
        } while (choice != 3);

        System.out.println("Выход из программы...");
    }
}
