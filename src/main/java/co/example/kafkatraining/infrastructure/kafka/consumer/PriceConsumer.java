package co.example.kafkatraining.infrastructure.kafka.consumer;

import co.example.kafkatraining.infrastructure.kafka.schemas.PriceDemandSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class PriceConsumer {

    @KafkaListener(
            id = "PRICE-GROUP",
            topics = "PRICE"
    )
    public void consume(PriceDemandSchema priceDemandSchema) {
        log.info("PRICE: {}" , priceDemandSchema);
    }
}
