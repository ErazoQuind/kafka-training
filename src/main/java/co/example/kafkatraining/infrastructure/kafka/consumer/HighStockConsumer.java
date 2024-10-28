package co.example.kafkatraining.infrastructure.kafka.consumer;

import co.example.kafkatraining.infrastructure.kafka.schemas.HighStockSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class HighStockConsumer {

    @KafkaListener(
            id = "HIGH-STOCK-GROUP",
            topics = "HIGH_STOCK"
    )
    public void consume(HighStockSchema highStockSchema) {
        log.info("HIGH_STOCK: {}" , highStockSchema);
    }
}
