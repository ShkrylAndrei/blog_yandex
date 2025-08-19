package info.shkryl.workWithFile.example1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("data.txt");

        if (Files.exists(path)) {
            System.out.println("Файл существует");
        } else {
            System.out.println("Файл не найден");
        }
    }
}
