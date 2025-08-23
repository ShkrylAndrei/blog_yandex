package info.shkryl.multithreading.example6;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        SafeCounter c = new SafeCounter();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) c.increment();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println(c.getCount());
    }
}

class SafeCounter {
    private int count = 0;

    public synchronized void increment() {
        count++; // теперь атомарно
    }

    public synchronized int getCount() {
        return count;
    }
}
