package co.example.kafkatraining.infrastructure.kafka.consumer;

import co.example.kafkatraining.infrastructure.kafka.schemas.InsufficientStockSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class InsufficientStockConsumer {

    @KafkaListener(
            id = "INSUFFICIENT-STOCK-GROUP",
            topics = "INSUFFICIENT_STOCK"
    )
    public void consume(InsufficientStockSchema insufficientStockSchema) {
        log.info("insufficientStockSchema: {}" , insufficientStockSchema);
    }
}
