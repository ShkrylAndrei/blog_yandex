package info.shkryl.useStream.example2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)      // оставить чётные
                .map(n -> n * n)              // возвести в квадрат
                .collect(Collectors.toList()); // собрать в список

        System.out.println(result);
    }
}
