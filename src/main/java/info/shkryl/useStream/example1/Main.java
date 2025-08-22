package info.shkryl.useStream.example1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = new ArrayList<>();

        for (Integer num : numbers) {
            if (num % 2 == 0) {
                result.add(num * num);
            }
        }

        System.out.println(result);
    }
}
