package co.example.kafkatraining.infrastructure.kafka.producers;

import co.example.kafkatraining.domain.model.InsufficientStock;
import co.example.kafkatraining.domain.port.InsufficientStockProducer;
import co.example.kafkatraining.infrastructure.kafka.mapper.InsufficientStockMapper;
import co.example.kafkatraining.infrastructure.kafka.schemas.InsufficientStockSchema;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@RequiredArgsConstructor
@Slf4j
public class InsufficientStockProducerImpl implements InsufficientStockProducer {

    private static final String TOPIC_NAME = "INSUFFICIENT_STOCK";


    private final KafkaTemplate<String, InsufficientStockSchema> kafkaTemplate;
    private final InsufficientStockMapper mapper;


    public void send(InsufficientStock insufficientStock) {

        InsufficientStockSchema message = mapper.to(insufficientStock);
        CompletableFuture<SendResult<String, InsufficientStockSchema>> result = kafkaTemplate.send(TOPIC_NAME, message.id(),message);

        result.thenAccept((insufficientStockSendResult)->
            log.info("Sent sample message [{}] to " + TOPIC_NAME, message)
        );

        result.exceptionally(ex -> {
            log.error("Error al enviar el mensaje: {}", ex.getMessage());
            return null;
        });

    }

}
