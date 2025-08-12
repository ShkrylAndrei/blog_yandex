package info.shkryl.useStatic.example3;

public class Main {
    public static void main(String[] args) {
        System.out.println(Config.getSetting("host")); // localhost
        // Статический блок уже выполнился при первом обращении к классу
    }
}
