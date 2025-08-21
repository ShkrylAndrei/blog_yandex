package info.shkryl.aboutGeneric.example2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(1.1);
        doubleList.add(2.2);
        doubleList.add(3.3);

        NumberList numberList = new NumberList();
        numberList.printNumbers(intList);    // Выводит: 1 2 3
        numberList.printNumbers(doubleList); // Выводит: 1.1 2.2 3.3
    }
}
