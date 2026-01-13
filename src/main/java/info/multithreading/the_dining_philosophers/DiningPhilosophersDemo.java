package info.multithreading.the_dining_philosophers;

public class DiningPhilosophersDemo {
    public static void main(String[] args) {
        int numPhilosophers = 5;
        Chopstick[] chopsticks = new Chopstick[numPhilosophers];
        for (int i = 0; i < numPhilosophers; i++) {
            chopsticks[i] = new Chopstick(i);
        }

        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Thread[] threads = new Thread[numPhilosophers];

        for (int i = 0; i < numPhilosophers; i++) {
            Chopstick left = chopsticks[i];
            Chopstick right = chopsticks[(i + 1) % numPhilosophers]; // круговой порядок
            philosophers[i] = new Philosopher(i, left, right);
            threads[i] = new Thread(philosophers[i], "Философ-" + i);
        }

        for (Thread t : threads) {
            t.start();
        }
    }
}
