package co.example.kafkatraining.infrastructure.kafka.producers;

import co.example.kafkatraining.infrastructure.kafka.schemas.RefundSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Slf4j
public class RefundProducer {

    // todo: se hace manualmente con un JSON por la consola de redpandas, evolucionara

    private static final String TOPIC_NAME = "REFUND_ALERTS";

    private final KafkaTemplate<String, RefundSchema> kafkaTemplate;

    public void send(RefundSchema message) {

        kafkaTemplate.send(TOPIC_NAME, message.id(), message);

    }


}

