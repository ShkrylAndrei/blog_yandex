package info.shkryl.aboutGeneric.example3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>();
        NumberConsumer numberConsumer = new NumberConsumer();
        numberConsumer.addIntegers(numberList);

        for (Object num : numberList) {
            System.out.println(num); // Выводит: 1 2 3
        }
    }
}
