package info.shkryl.forkjoinpool;

import java.util.concurrent.CompletableFuture;

public class CommonPoolExample {
    public static void main(String[] args) {
        // CompletableFuture по умолчанию использует ForkJoinPool.commonPool()
        CompletableFuture.supplyAsync(() -> {
            System.out.println("Running in: " + Thread.currentThread().getName());
            return "Result";
        }).join();
    }
}
