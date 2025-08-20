package info.shkryl.workWithClone.example2;

public class CloneExample {
    public static void main(String[] args) {
        try {
            Person original = new Person("Alice", 30);
            Person copy = (Person) original.clone(); // Приведение типа

            copy.setName("Bob");

            System.out.println("Оригинал: " + original); // Person{name='Alice', age=30}
            System.out.println("Копия: " + copy);       // Person{name='Bob', age=30}

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
