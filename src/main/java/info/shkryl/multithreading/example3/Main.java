package info.shkryl.multithreading.example3;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task = () -> {
            Thread.sleep(1000);
            return 42;
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(task);

        System.out.println("Жду...");
        Integer result = future.get(); // блокирует до готовности
        System.out.println("Результат: " + result);

        executor.shutdown();
    }
}
