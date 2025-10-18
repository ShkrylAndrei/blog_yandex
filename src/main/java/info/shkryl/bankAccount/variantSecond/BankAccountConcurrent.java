package info.shkryl.bankAccount.variantSecond;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccountConcurrent {
    static class Account {
        private final AtomicInteger balance = new AtomicInteger(10_000);
        private final ReentrantLock lock = new ReentrantLock();
        private final Condition fundsAvailable = lock.newCondition();
        private volatile int waitingThreads = 0;
        private volatile boolean shutdown = false;

        public void operate(String threadName) throws InterruptedException {
            while (!shutdown) {
                lock.lock();
                try {
                    if (waitingThreads == 3) {
                        System.out.println("Все потоки ожидают пополнения, " +
                                "но никто не может пополнить счёт. Завершение работы.");
                        shutdown = true;
                        fundsAvailable.signalAll();
                        return;
                    }

                    int amount = (int) (Math.random() * 5000) + 1;
                    boolean isDeposit = Math.random() < 0.5;

                    if (isDeposit) {
                        balance.addAndGet(amount);
                        System.out.printf("[%s] Пополнил счёт на %d. Баланс: %d%n", threadName, amount, balance.get());
                        fundsAvailable.signalAll();
                    } else {
                        if (balance.get() >= amount) {
                            balance.addAndGet(-amount);
                            System.out.printf("[%s] Снял %d. Баланс: %d%n", threadName, amount, balance.get());
                        } else {
                            System.out.printf("[%s] Недостаточно средств " +
                                    "для снятия %d. Жду пополнения...%n", threadName, amount);
                            waitingThreads++;
                            try {
                                // Ждём с таймаутом
                                boolean signalled = fundsAvailable.await(3, java.util.concurrent.TimeUnit.SECONDS);
                                if (!signalled && !shutdown) {
                                    // Таймаут — проверим, не все ли ждут
                                }
                            } finally {
                                waitingThreads--;
                            }
                            continue;
                        }
                    }
                } finally {
                    lock.unlock();
                }
                Thread.sleep(200);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();

        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            final int id = i + 1;
            threads[i] = new Thread(() -> {
                try {
                    account.operate("Поток-" + id);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        for (Thread t : threads) t.start();

        Thread.sleep(10_000);

        if (account.shutdown) {
            for (Thread t : threads) t.join(100);
        } else {
            System.out.println("Программа завершена по таймауту.");
        }
    }
}
