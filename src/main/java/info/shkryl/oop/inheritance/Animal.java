package info.shkryl.oop.inheritance;

// Родительский класс
public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void makeSound() {
        System.out.println("Животное издаёт звук");
    }
}
