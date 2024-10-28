package co.example.kafkatraining.infrastructure.kafka.producers;

import co.example.kafkatraining.domain.model.LowStock;
import co.example.kafkatraining.domain.port.LowStockProducer;
import co.example.kafkatraining.infrastructure.kafka.mapper.LowStockMapper;
import co.example.kafkatraining.infrastructure.kafka.schemas.LowStockSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class LowStockProducerImpl implements LowStockProducer {

    private static final String TOPIC_NAME = "LOW_STOCK";

    private final KafkaTemplate<String, LowStockSchema> kafkaTemplate;
    private final LowStockMapper mapper;

    @Override
    public void send(LowStock lowStock) {
        LowStockSchema message =  mapper.to(lowStock);
        kafkaTemplate.send(TOPIC_NAME, message.id(), message);

    }


}

