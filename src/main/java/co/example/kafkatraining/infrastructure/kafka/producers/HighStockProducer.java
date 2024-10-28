package co.example.kafkatraining.infrastructure.kafka.producers;

import co.example.kafkatraining.infrastructure.kafka.schemas.HighStockSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class HighStockProducer {

    private static final String TOPIC_NAME = "HIGH_STOCK";

    private final KafkaTemplate<String, HighStockSchema> kafkaTemplate;

    public void send(HighStockSchema message) {
        kafkaTemplate.send(TOPIC_NAME, message.id(), message);
    }


}

