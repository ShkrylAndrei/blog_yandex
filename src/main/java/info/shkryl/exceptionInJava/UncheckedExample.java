package info.shkryl.exceptionInJava;

public class UncheckedExample {
    public static void main(String[] args) {
        String str = null;
        try {
            System.out.println(str.length()); // NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Строка равна null!");
        }
    }
}
