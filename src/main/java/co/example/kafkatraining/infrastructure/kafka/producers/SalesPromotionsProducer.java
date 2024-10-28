package co.example.kafkatraining.infrastructure.kafka.producers;

import co.example.kafkatraining.infrastructure.kafka.schemas.SaleSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class SalesPromotionsProducer {
    // todo: se hace manualmente con un JSON por la consola de redpandas

    private static final String TOPIC_NAME = "SALES_PROMOTIONS_ALERTS";

    private final KafkaTemplate<String, SaleSchema> kafkaTemplate;

    public void send(SaleSchema message) {

        kafkaTemplate.send(TOPIC_NAME, message.saleId(), message);

    }


}

