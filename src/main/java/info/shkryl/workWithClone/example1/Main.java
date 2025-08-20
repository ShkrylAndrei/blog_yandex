package info.shkryl.workWithClone.example1;

public class Main {
    public static void main(String[] args) {
        Person original = new Person("Alice", 30);
        Person copy = original; // Копируется ссылка, а не объект!

        copy.setName("Bob");

        System.out.println(original.getName()); // Вывод: "Bob" — изменился оригинал!
    }
}
