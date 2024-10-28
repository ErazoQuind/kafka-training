package co.example.kafkatraining.infrastructure.kafka.consumer;

import co.example.kafkatraining.infrastructure.kafka.schemas.SaleSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SalesPromotionsConsumer {

    @KafkaListener(
            id = "SALES-PROMOTION-GROUP",
            topics = "SALES-PROMOTION"
    )
    public void consume(SaleSchema saleSchema) {
        log.info("sale: {}" , saleSchema);
    }
}
