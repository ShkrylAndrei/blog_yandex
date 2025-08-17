package info.shkryl.useException.exampleSix;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public void readFile(String filename) throws IOException {
        FileInputStream fis = new FileInputStream(filename);
        // ...
    }
}
