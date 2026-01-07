package info.microservices.fault_tolerance.circuit_breaker;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.function.Supplier;

public class PaymentService {

    private final CircuitBreaker circuitBreaker;

    public PaymentService() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofSeconds(30))
                .slidingWindowSize(10)
                .minimumNumberOfCalls(5)
                .build();

        CircuitBreakerRegistry registry = CircuitBreakerRegistry.of(config);
        this.circuitBreaker = registry.circuitBreaker("paymentService");
    }

    public CompletableFuture<String> processPayment(String orderId) {
        // 1. Создаём Supplier для внешнего вызова
        Supplier<CompletionStage<String>> supplier = () -> callExternalPaymentService(orderId);

        // 2. ОБОРАЧИВАЕМ через decorateCompletionStage — возвращает CompletionStage
        CompletionStage<String> decoratedStage = CircuitBreaker
                .decorateCompletionStage(circuitBreaker, supplier).get();

        // 3. Добавляем fallback через handle
        return (CompletableFuture<String>) decoratedStage
                .handle((result, throwable) -> {
                    if (throwable != null) {
                        System.err.println("Payment failed or circuit is OPEN: " + throwable.getMessage());
                        return "FALLBACK: Payment processing delayed for " + orderId;
                    }
                    return result;
                });
    }

    private CompletableFuture<String> callExternalPaymentService(String orderId) {
        if (Math.random() > 0.4) {
            return CompletableFuture.failedFuture(new RuntimeException("External API is down"));
        }
        return CompletableFuture.completedFuture("Payment " + orderId + " succeeded");
    }

    public static void main(String[] args) throws InterruptedException {
        PaymentService paymentService = new PaymentService();

        for (int i = 0; i < 20; i++) {
            CompletableFuture<String> result = paymentService.processPayment("order-" + i);
            try {
                System.out.println("Result: " + result.get());
            } catch (Exception e) {
                System.err.println("Exception: " + e.getCause().getMessage());
            }
            Thread.sleep(100); // небольшая пауза
        }
    }
}
