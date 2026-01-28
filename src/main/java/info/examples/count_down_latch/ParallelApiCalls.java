package info.examples.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ParallelApiCalls {

    public static void main(String[] args) throws InterruptedException {
        int taskCount = 3;
        CountDownLatch completionLatch = new CountDownLatch(taskCount);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Запускаем задачи
        executor.submit(() -> {
            System.out.println("Запрос к API 1...");
            simulateWork(1000);
            System.out.println("API 1 ответил");
            completionLatch.countDown();
        });

        executor.submit(() -> {
            System.out.println("Запрос к API 2...");
            simulateWork(1200);
            System.out.println("API 2 ответил");
            completionLatch.countDown();
        });

        executor.submit(() -> {
            System.out.println("Запрос к API 3...");
            simulateWork(800);
            System.out.println("API 3 ответил");
            completionLatch.countDown();
        });

        // Ждём завершения ВСЕХ задач
        completionLatch.await();
        System.out.println("Все API ответили. Можно агрегировать результаты.");

        executor.shutdown();
    }

    private static void simulateWork(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
    }
}
