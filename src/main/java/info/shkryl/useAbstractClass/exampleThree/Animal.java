package info.shkryl.useAbstractClass.exampleThree;

abstract class Animal {
    protected String name;

    // Конструктор в абстрактном классе
    public Animal(String name) {
        this.name = name;
        System.out.println("Animal конструктор: " + name);
    }

    public abstract void makeSound();
}
