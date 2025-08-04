package info.shkryl.getdata;

import java.util.Scanner;

public class GetSomeNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите три числа через пробел:");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int sum = a + b + c;
        System.out.println("Сумма: " + sum);
    }
}
