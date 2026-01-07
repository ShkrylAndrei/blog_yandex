package info.microservices.fault_tolerance.retry;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;

import java.time.Duration;
import java.util.function.Supplier;

public class SomeService {

   public String checkRetry() {

       RetryConfig config = RetryConfig.custom()
               .maxAttempts(3)
               .waitDuration(Duration.ofMillis(100))
               .build();

       Retry retry = Retry.of("paymentRetry", config);
       Supplier<String> decorated = Retry.decorateSupplier(retry, this::callExternalService);

       return decorated.get();
   }

    private String callExternalService() {
        // Имитация долгого вызова
        try { Thread.sleep(5000); } catch (InterruptedException e) { }
        return "Done";
    }

    public static void main(String[] args) {
        SomeService someService = new SomeService();
        String result = someService.checkRetry();
        System.out.println(result);
    }
}
