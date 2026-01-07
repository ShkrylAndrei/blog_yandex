package info.microservices.fault_tolerance.timeout;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class SomeService {

    public CompletableFuture<String> callWithTimeout() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(this::slowExternalCall);

        // Ждём максимум 2 секунды
        return future.orTimeout(2, TimeUnit.SECONDS)
                .exceptionally(throwable -> "FALLBACK: Timeout occurred");
    }

    private String slowExternalCall() {
        // Имитация долгого вызова
        try { Thread.sleep(5000); } catch (InterruptedException e) { }
        return "Done";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SomeService someService = new SomeService();
        CompletableFuture<String> result = someService.callWithTimeout();
        System.out.println(result.get());
    }
}
