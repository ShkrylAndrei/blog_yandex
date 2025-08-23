package info.shkryl.multithreading.example8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 0; i < 5; i++) {
            final int taskNum = i;
            executor.submit(() -> {
                System.out.println("Выполняю задачу " + taskNum + " в " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}
