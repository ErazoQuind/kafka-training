package co.example.kafkatraining.domain.port;

import co.example.kafkatraining.domain.model.InsufficientStock;

public interface InsufficientStockProducer {
    void send(InsufficientStock insufficientStock);
}
