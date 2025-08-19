package info.shkryl.workWithFile.example2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("new_file.txt");

        try {
            if (Files.notExists(path)) {
                Files.createFile(path);
                System.out.println("Файл создан: " + path);
            }
        } catch (Exception e) {
            System.err.println("Ошибка при создании файла: " + e.getMessage());
        }
    }
}
