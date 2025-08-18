package info.shkryl.useAnnotation.example3;

import java.util.ArrayList;
import java.util.List;

public class LegacyClass {
    private static List list = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public List<String> legacyMethod() {
        return (List<String>) getList(); // Небезопасное приведение
    }

    public List getList(){
        return list;
    }
}
