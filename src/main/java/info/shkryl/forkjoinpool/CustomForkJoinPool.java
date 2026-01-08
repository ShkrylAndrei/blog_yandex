package info.shkryl.forkjoinpool;

import java.util.concurrent.ForkJoinPool;

public class CustomForkJoinPool {
    public static void main(String[] args) {
        // Создаём пул с 4 потоками
        ForkJoinPool customPool = new ForkJoinPool(4);

        customPool.submit(() -> {
            System.out.println("Task in custom pool: " + Thread.currentThread().getName());
            // Ваша вычислительная задача
        }).join();

        customPool.shutdown(); // Не забудьте!
    }
}
