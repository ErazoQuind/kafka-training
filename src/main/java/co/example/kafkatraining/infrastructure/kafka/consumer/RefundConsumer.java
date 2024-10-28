package co.example.kafkatraining.infrastructure.kafka.consumer;

import co.example.kafkatraining.infrastructure.kafka.schemas.RefundSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class RefundConsumer {

    @KafkaListener(
            id = "REFUND-GROUP",
            topics = "REFUND"
    )
    public void consume(RefundSchema refundSchema) {
        log.info("refundSchema: {}" , refundSchema);
    }
}
