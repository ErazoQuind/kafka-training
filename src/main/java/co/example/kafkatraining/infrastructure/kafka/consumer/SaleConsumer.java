package co.example.kafkatraining.infrastructure.kafka.consumer;

import co.example.kafkatraining.domain.handler.SalesHandler;
import co.example.kafkatraining.infrastructure.kafka.mapper.SaleMapper;
import co.example.kafkatraining.infrastructure.kafka.schemas.SaleSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class SaleConsumer {
    private final SalesHandler handler;
    private final SaleMapper mapper;
    @KafkaListener(
            id = "SALES-GROUP",
            topics = "SALES"
    )
    public void consume(SaleSchema saleSchema) {
        log.info("sale: {}" , saleSchema);
        handler.process(mapper.to(saleSchema));
    }
}
