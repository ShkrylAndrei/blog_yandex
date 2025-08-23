package info.shkryl.multithreading.example5;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) c.increment();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println(c.count); // часто < 2000!
    }
}

class Counter {
    int count = 0;
    void increment() { count++; } // НЕ атомарно!
}
