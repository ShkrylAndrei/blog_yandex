package info.shkryl.controlStructures;

import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        // Программа: угадай число
        int secret = 7;
        int guess = 0;
        Scanner sc = new Scanner(System.in);

        while (guess != secret) {
            System.out.print("Угадайте число (1-10): ");
            guess = sc.nextInt();

            if (guess < secret) {
                System.out.println("Больше!");
            } else if (guess > secret) {
                System.out.println("Меньше!");
            } else {
                System.out.println("Поздравляем! Вы угадали!");
            }
        }
    }
}
