package info.shkryl.multithreading.example9;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                try {
                    startSignal.await(); // ждём старта
                    System.out.println("Бегу!");
                    doneSignal.countDown();
                } catch (InterruptedException e) {}
            }).start();
        }

        Thread.sleep(1000);
        startSignal.countDown(); // старт!
        doneSignal.await(); // ждём финиша
        System.out.println("Все пришли!");
    }
}
