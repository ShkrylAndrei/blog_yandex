package info.shkryl.workWithFile.example7FilesWrite;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> lines = List.of("Первая строка", "Вторая строка", "Третья строка");

        try {
            Files.write(Paths.get("output.txt"), lines, StandardCharsets.UTF_8);
            System.out.println("Данные записаны");
        } catch (IOException e) {
            System.err.println("Ошибка записи: " + e.getMessage());
        }
    }
}
