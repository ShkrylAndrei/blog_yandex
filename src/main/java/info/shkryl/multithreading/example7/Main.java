package info.shkryl.multithreading.example7;

public class Main {
    public static void main(String[] args) {
        FlagExample flag = new FlagExample();
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            flag.stop();
        });
        Thread thread2 = new Thread(() -> flag.run());
        thread2.start(); thread1.start();
    }
}

class FlagExample {
    volatile boolean running = true;
    void stop() {
        running = false;
    }
    void run() {
        while (running) {
            // работает...
            System.out.println("работает...");
        }
        System.out.println("Остановлен");
    }
}
