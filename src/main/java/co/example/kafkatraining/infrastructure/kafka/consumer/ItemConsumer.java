package co.example.kafkatraining.infrastructure.kafka.consumer;

import co.example.kafkatraining.infrastructure.kafka.schemas.ItemSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ItemConsumer {

    @KafkaListener(
            id = "ITEM-GROUP",
            topics = "ITEM"
    )
    public void consume(ItemSchema itemSchema) {
        log.info("ITEM: {}" , itemSchema);
    }
}
