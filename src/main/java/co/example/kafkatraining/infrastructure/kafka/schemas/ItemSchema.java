package co.example.kafkatraining.infrastructure.kafka.schemas;

public record ItemSchema(String id,
                         int quantity,
                         String sale) {
}
