package info.shkryl.useException.exampleTwo;

public class Main {
    public static void main(String[] args) {
        try {
            int[] arr = new int[5];
            arr[10] = 1; // ArrayIndexOutOfBoundsException
            int x = 10 / 0; // ArithmeticException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за границы массива: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Деление на ноль: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Другая ошибка: " + e.getMessage());
        }
    }
}
