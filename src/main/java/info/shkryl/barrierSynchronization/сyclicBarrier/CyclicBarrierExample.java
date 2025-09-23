package info.shkryl.barrierSynchronization.сyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

    public static void main(String[] args) {
        int numberOfWorkers = 3;
        CyclicBarrier barrier = new CyclicBarrier(numberOfWorkers, () -> {
            System.out.println(">>> Этап завершён. Все потоки синхронизированы.");
        });

        ExecutorService executor = Executors.newFixedThreadPool(numberOfWorkers);

        for (int i = 1; i <= numberOfWorkers; i++) {
            final int workerId = i;
            executor.submit(() -> {
                try {
                    for (int phase = 1; phase <= 3; phase++) {
                        System.out.println("Поток " + workerId + " работает над этапом " + phase);
                        Thread.sleep((long)(Math.random() * 1000));

                        System.out.println("Поток " + workerId + " достиг барьера этапа " + phase);
                        barrier.await(); // ждём остальных

                        System.out.println("Поток " + workerId + " продолжает после этапа " + phase);
                    }
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
    }
}
