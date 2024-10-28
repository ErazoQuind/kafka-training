package co.example.kafkatraining.infrastructure.kafka.schemas;

import lombok.Builder;

@Builder
public record HighStockSchema(String id, String saleId, String customerId, String description) {
}
