package info.shkryl.barrierSynchronization.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        int numberOfServices = 3;
        CountDownLatch latch = new CountDownLatch(numberOfServices);

        ExecutorService executor = Executors.newFixedThreadPool(numberOfServices);

        for (int i = 1; i <= numberOfServices; i++) {
            final int serviceNumber = i;
            executor.submit(() -> {
                try {
                    System.out.println("Запуск сервиса " + serviceNumber);
                    Thread.sleep(1000 + (long)(Math.random() * 2000)); // имитация работы
                    System.out.println("Сервис " + serviceNumber + " запущен");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    latch.countDown(); // сигнализируем о завершении
                }
            });
        }

        System.out.println("Ожидание запуска всех сервисов...");
        latch.await(); // главный поток ждёт
        System.out.println("Все сервисы запущены. Приложение готово к работе!");

        executor.shutdown();
    }
}
