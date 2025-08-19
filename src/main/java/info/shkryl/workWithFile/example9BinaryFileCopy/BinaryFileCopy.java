package info.shkryl.workWithFile.example9BinaryFileCopy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BinaryFileCopy {
    public static void copyFile(String source, String target) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(target)) {

            int byteRead;
            while ((byteRead = fis.read()) != -1) {
                fos.write(byteRead);
            }

            System.out.println("Файл скопирован");

        } catch (IOException e) {
            System.err.println("Ошибка копирования: " + e.getMessage());
        }
    }
}
