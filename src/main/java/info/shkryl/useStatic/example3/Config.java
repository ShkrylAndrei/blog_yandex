package info.shkryl.useStatic.example3;

import java.util.HashMap;
import java.util.Map;

public class Config {
    private static Map<String, String> settings;

    // Статический блок инициализации
    static {
        settings = new HashMap<>();
        settings.put("host", "localhost");
        settings.put("port", "8080");
        settings.put("debug", "true");
        System.out.println("Конфигурация загружена.");
    }

    public static String getSetting(String key) {
        return settings.get(key);
    }
}
