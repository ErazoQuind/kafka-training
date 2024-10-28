package co.example.kafkatraining.infrastructure.kafka.producers;

import co.example.kafkatraining.infrastructure.kafka.schemas.PriceDemandSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class PriceDemandProducer {

    private static final String TOPIC_NAME = "PRICE_DEMAND_ALERTS";

    private final KafkaTemplate<String, PriceDemandSchema> kafkaTemplate;

    public void send(PriceDemandSchema message) {

        kafkaTemplate.send(TOPIC_NAME, message.id(), message);

    }


}

