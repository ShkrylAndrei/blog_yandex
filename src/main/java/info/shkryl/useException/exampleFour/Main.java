package info.shkryl.useException.exampleFour;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Автоматически закрывает ресурсы, реализующие AutoCloseable
        try (FileInputStream fis = new FileInputStream("file.txt");
             BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {

            String line = reader.readLine();
            System.out.println(line);

        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        }
// fis и reader закроются автоматически!
    }
}
