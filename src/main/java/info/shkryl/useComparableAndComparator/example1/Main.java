package info.shkryl.useComparableAndComparator.example1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Инициализация
        List<Person> people = new ArrayList<>();
        people.add(new Person("Charlie", 35));
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));


        //Сравнение
        Collections.sort(people);
        System.out.println(people);
    }
}
