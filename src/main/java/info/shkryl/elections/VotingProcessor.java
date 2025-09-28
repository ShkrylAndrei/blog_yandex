package info.shkryl.elections;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class VotingProcessor {
    private static final String TOPIC = "votes";
    private KafkaProducer<String, String> producer;
    private Set<String> receivedVotes = ConcurrentHashMap.newKeySet(); // thread-safe set

    public VotingProcessor(String bootstrapServers) {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        producer = new KafkaProducer<>(props);
    }

    public void processVote(String voterId, String candidate) {
        if (receivedVotes.add(voterId)) { // checks if the vote is not a duplicate
            String message = String.format("Voter: %s voted for %s", voterId, candidate);
            producer.send(new ProducerRecord<>(TOPIC, voterId, candidate),
                    (metadata, exception) -> {
                        if (exception == null) {
                            System.out.println("Vote processed: " + message);
                        } else {
                            exception.printStackTrace();
                        }
                    });
        } else {
            System.out.println("Duplicate vote detected from voter: " + voterId);
        }
    }

    public void close() {
        producer.close();
    }

    public static void main(String[] args) {
        VotingProcessor processor = new VotingProcessor("localhost:9092");
        // Simulate receiving votes here or via other threads
        processor.processVote("voter1", "candidateA");
        processor.processVote("voter2", "candidateB");
        processor.processVote("voter1", "candidateA"); // Duplicate

        processor.close();
    }
}
