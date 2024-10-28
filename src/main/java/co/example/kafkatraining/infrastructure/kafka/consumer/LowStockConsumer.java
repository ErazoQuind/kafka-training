package co.example.kafkatraining.infrastructure.kafka.consumer;

import co.example.kafkatraining.infrastructure.kafka.schemas.LowStockSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class LowStockConsumer {

    @KafkaListener(
            id = "LOW-STOCK-GROUP",
            topics = "LOW-STOCK"
    )
    public void consume(LowStockSchema lowStockSchema) {
        log.info("lowStockSchema: {}" , lowStockSchema);
    }
}
