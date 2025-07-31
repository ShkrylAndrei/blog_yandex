package info.shkryl.ClassAndObject;

public class Person {
    // Поля класса
    String name;
    int age;

    // Конструктор
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Метод
    public void sayHello() {
        System.out.println("Привет! Меня зовут " + name + ", мне " + age + " лет.");
    }
}