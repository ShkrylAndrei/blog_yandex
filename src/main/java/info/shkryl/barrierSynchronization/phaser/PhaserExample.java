package info.shkryl.barrierSynchronization.phaser;

import java.util.concurrent.Phaser;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PhaserExample {

    public static void main(String[] args) throws InterruptedException {
        Phaser phaser = new Phaser(1); // 1 — главный поток (наблюдатель)

        ExecutorService executor = Executors.newCachedThreadPool();

        // Стартуем 3 задачи
        for (int i = 1; i <= 3; i++) {
            phaser.register(); // регистрируем участника
            final int taskId = i;
            executor.submit(() -> {
                try {
                    System.out.println("Задача " + taskId + " начала выполнение");
                    try {
                        Thread.sleep(1000 + (long)(Math.random() * 2000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Задача " + taskId + " завершена");
                } finally {
                    phaser.arriveAndDeregister(); // прибыл и покинул
                }
            });
        }

        // Ждём завершения первой группы задач
        System.out.println("Ожидание завершения первой группы задач...");
        phaser.arriveAndAwaitAdvance(); // наблюдатель ждёт

        System.out.println("Первая группа задач завершена. Запускаем ещё 2 задачи...");

        // Добавляем ещё 2 задачи
        for (int i = 4; i <= 5; i++) {
            phaser.register();
            final int taskId = i;
            executor.submit(() -> {
                try {
                    System.out.println("Задача " + taskId + " начала выполнение");
                    try {
                        Thread.sleep(1000 + (long)(Math.random() * 2000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Задача " + taskId + " завершена");
                } finally {
                    phaser.arriveAndDeregister();
                }
            });
        }

        // Ждём вторую группу
        phaser.arriveAndAwaitAdvance();
        System.out.println("Все задачи завершены!");

        executor.shutdown();
    }
}
