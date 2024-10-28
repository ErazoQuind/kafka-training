package co.example.kafkatraining.infrastructure.kafka.consumer;

import co.example.kafkatraining.infrastructure.kafka.schemas.PurchaseOrderSchema;
import co.example.kafkatraining.infrastructure.kafka.schemas.SaleSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PurchaseOrderConsumer {

    @KafkaListener(
            id = "PURCHASE-ORDER-GROUP",
            topics = "PURCHASE-ORDER"
    )
    public void consume(PurchaseOrderSchema purchaseOrderSchema) {
        log.info("purchaseOrderSchema: {}" , purchaseOrderSchema);
    }
}
