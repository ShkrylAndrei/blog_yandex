package info.shkryl.primitive;

public class User {

    int age = 30;
    double salary = 75000.50;
    char gender = 'M';
    boolean isActive = true;
    byte children = 2;

    public void printInfo() {
        System.out.println("Возраст: " + age);
        System.out.println("Зарплата: " + salary);
        System.out.println("Пол: " + gender);
        System.out.println("Активен: " + isActive);
        System.out.println("Детей: " + children);
    }

    public static void main(String[] args) {

        User user = new User();
        user.printInfo();
    }
}
