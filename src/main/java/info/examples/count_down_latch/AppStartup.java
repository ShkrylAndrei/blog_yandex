package info.examples.count_down_latch;

import java.util.concurrent.CountDownLatch;

public class AppStartup {

    public static void main(String[] args) throws InterruptedException {
        int serviceCount = 3;
        CountDownLatch startupLatch = new CountDownLatch(serviceCount);

        // Запускаем инициализацию сервисов в отдельных потоках
        new Thread(() -> {
            System.out.println("Инициализация БД...");
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            System.out.println("БД готова");
            startupLatch.countDown(); // Готово!
        }).start();

        new Thread(() -> {
            System.out.println("Инициализация Redis...");
            try { Thread.sleep(1500); } catch (InterruptedException e) {}
            System.out.println("Redis готов");
            startupLatch.countDown();
        }).start();

        new Thread(() -> {
            System.out.println("Подключение к Kafka...");
            try { Thread.sleep(1800); } catch (InterruptedException e) {}
            System.out.println("Kafka подключена");
            startupLatch.countDown();
        }).start();

        // Главный поток ждёт, пока все сервисы не скажут "готово"
        System.out.println("Ожидание готовности всех сервисов...");
        startupLatch.await(); // ← БЛОКИРУЕТСЯ здесь

        System.out.println("Все сервисы готовы! Запускаем основное приложение.");
        // ... запуск бизнес-логики
    }
}
