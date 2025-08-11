package info.shkryl.useAbstractClass.exampleThree;

class Dog extends Animal {
    private String breed;

    // Конструктор подкласса
    public Dog(String name, String breed) {
        super(name);  // Явный вызов конструктора абстрактного класса
        this.breed = breed;
        System.out.println("Dog конструктор: " + breed);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Гав!");
    }
}
