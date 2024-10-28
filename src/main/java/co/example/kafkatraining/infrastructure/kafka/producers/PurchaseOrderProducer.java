package co.example.kafkatraining.infrastructure.kafka.producers;

import co.example.kafkatraining.infrastructure.kafka.schemas.PurchaseOrderSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class PurchaseOrderProducer {

    private static final String TOPIC_NAME = "PURCHASE_ALERTS";

    private final KafkaTemplate<String, PurchaseOrderSchema> kafkaTemplate;

    public void send(PurchaseOrderSchema message) {

        kafkaTemplate.send(TOPIC_NAME, message.id(), message);

    }


}

