package info.shkryl.useException.exampleOne;

public class Main {
    public static void main(String[] args) {
        try {
            // Код, который может выбросить исключение
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            // Обработка исключения
            System.out.println("Ошибка: деление на ноль!");
            System.out.println("Сообщение: " + e.getMessage());
        }
    }
}
