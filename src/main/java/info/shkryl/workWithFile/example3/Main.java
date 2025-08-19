package info.shkryl.workWithFile.example3;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("new_file.txt");

        try {
            if (Files.notExists(path)) {
                System.out.println("Файл не найден, удалять нечего.");
            }else {
                Files.delete(path);
                System.out.println("Файл удалён");
            }
        } catch (Exception e) {
            System.err.println("Ошибка удаления: " + e.getMessage());
        }
    }
}
