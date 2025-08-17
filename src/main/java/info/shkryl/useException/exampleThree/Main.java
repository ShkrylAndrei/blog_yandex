package info.shkryl.useException.exampleThree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("file.txt");
            // работа с файлом
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        } finally {
            // Закрытие ресурсов
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("Ошибка при закрытии файла: " + e.getMessage());
                }
            }
            System.out.println("Блок finally выполнен.");
        }
    }
}
