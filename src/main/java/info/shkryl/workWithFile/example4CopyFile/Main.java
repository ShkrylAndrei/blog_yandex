package info.shkryl.workWithFile.example4CopyFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path source = Paths.get("source.txt");
        Path target = Paths.get("backup.txt");

        try {
            Files.copy(source, target);
            System.out.println("Файл скопирован");
        } catch (Exception e) {
            System.err.println("Ошибка копирования: " + e.getMessage());
        }
    }
}
