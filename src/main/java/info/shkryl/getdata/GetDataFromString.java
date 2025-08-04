package info.shkryl.getdata;

import java.util.Scanner;

public class GetDataFromString {

    public static void main(String[] args) {
        String data = "Apple 5";
        Scanner scanner = new Scanner(data);

        String fruit = scanner.next();      // "Apple"
        int count = scanner.nextInt();      // 5

        System.out.println(fruit + ": " + count + " шт.");
    }
}
