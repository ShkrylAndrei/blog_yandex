package info.shkryl.controlStructures;

public class CheckAge {

    public static void main(String[] args) {

        int age = 18;

        if (age < 18) {
            System.out.println("Доступ запрещён");
        } else if (age == 18) {
            System.out.println("Добро пожаловать — тебе ровно 18!");
        } else {
            System.out.println("Добро пожаловать!");
        }
    }
}
