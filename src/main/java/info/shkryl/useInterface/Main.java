package info.shkryl.useInterface;

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        Animal myCat = new Cat();

        myDog.makeSound(); // Вывод: Bark
        myDog.eat();       // Вывод: Dog is eating

        myCat.makeSound(); // Вывод: Meow
        myCat.eat();       // Вывод: Cat is eating
    }
}
