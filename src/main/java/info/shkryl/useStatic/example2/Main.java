package info.shkryl.useStatic.example2;

public class Main {
    public static void main(String[] args) {
        int sum = MathUtils.add(5, 7);
        System.out.println("Сумма: " + sum); // 12

        System.out.println(MathUtils.isEven(10)); // true
    }
}
