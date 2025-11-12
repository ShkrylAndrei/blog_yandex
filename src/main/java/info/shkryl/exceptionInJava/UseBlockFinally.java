package info.shkryl.exceptionInJava;

import java.io.FileReader;
import java.io.IOException;

public class UseBlockFinally {
    public void loadData() {
        FileReader reader = null;
        try {
            reader = new FileReader("file.txt");
            // чтение файла
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
