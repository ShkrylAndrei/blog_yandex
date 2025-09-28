package info.shkryl.elections;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class VotingSimulator {
    private final int numberOfVoters;
    private final VotingProcessor processor;

    public VotingSimulator(int numberOfVoters, VotingProcessor processor) {
        this.numberOfVoters = numberOfVoters;
        this.processor = processor;
    }

    public void simulateVoting() {
        // pool size can be adjusted
        ExecutorService executorService = Executors.newFixedThreadPool(10);


        for (int i = 0; i < numberOfVoters; i++) {
            final int voterId = i;
            executorService.submit(() -> {
                String candidate = "candidate" + ((char)('A' + ThreadLocalRandom.current().nextInt(3)));
                processor.processVote("voter" + voterId, candidate);
            });
        }

        try {
            // Ждём завершения всех задач (максимум 15 секунд)
            if (!executorService.awaitTermination(15, TimeUnit.SECONDS)) {
                executorService.shutdownNow(); // Принудительно завершить, если не уложились
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        VotingProcessor processor = new VotingProcessor("localhost:9092");
        // Simulate voting from 100 people
        VotingSimulator simulator = new VotingSimulator(100, processor);
        simulator.simulateVoting();
        processor.close();
    }
}
