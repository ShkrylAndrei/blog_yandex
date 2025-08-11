package info.shkryl.useInterface.defaultMethod;

class Dog implements Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
}
