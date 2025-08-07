package info.shkryl.immutableCollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example1 {

    public static void main(String[] args) {
        List<String> mutable = new ArrayList<>();
        mutable.add("Анна");
        mutable.add("Иван");

        // Создаём неизменяемое "представление"
        List<String> immutable = Collections.unmodifiableList(mutable);

        // immutable.add("Мария"); // UnsupportedOperationException
    }
}
