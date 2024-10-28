package co.example.kafkatraining.infrastructure.kafka.producers;

import co.example.kafkatraining.infrastructure.kafka.schemas.LowStockSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class ItemProducer {

    // todo: se hace manualmente con un JSON por la consola de redpandas, evolucionara

    private static final String TOPIC_NAME = "ITEM";

    private final KafkaTemplate<String, LowStockSchema> kafkaTemplate;

    public void send(LowStockSchema message) {

        kafkaTemplate.send(TOPIC_NAME, message.id(), message);

    }


}

