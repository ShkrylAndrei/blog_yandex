package info.multithreading.the_dining_philosophers;

class Chopstick {
    private final int id;
    public Chopstick(int id) { this.id = id; }
    public int getId() { return id; }
}

public class Philosopher implements Runnable {
    private final int id;
    private final Chopstick leftChopstick;
    private final Chopstick rightChopstick;

    public Philosopher(int id, Chopstick left, Chopstick right) {
        this.id = id;
        this.leftChopstick = left;
        this.rightChopstick = right;
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                // Пытаемся взять обе вилки
                synchronized (leftChopstick) {
                    System.out.println("Философ " + id + " взял левую вилку " + leftChopstick.getId());
                    Thread.sleep(100); // имитация задержки — повышает шанс deadlock'а

                    synchronized (rightChopstick) {
                        System.out.println("Философ " + id + " взял правую вилку " + rightChopstick.getId());
                        eat();
                        System.out.println("Философ " + id + " поел и положил вилки");
                    }
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Философ " + id + " думает...");
        Thread.sleep(1000);
    }

    private void eat() throws InterruptedException {
        System.out.println("Философ " + id + " ест...");
        Thread.sleep(1000);
    }
}
