package co.example.kafkatraining.domain.port;

import co.example.kafkatraining.domain.model.LowStock;

public interface LowStockProducer {
    void send(LowStock lowStock);
}
