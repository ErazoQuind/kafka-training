package co.example.kafkatraining.infrastructure.kafka.schemas;

import lombok.Builder;

@Builder
public record InsufficientStockSchema(String id, String saleId, String customerId, String description) {
}
