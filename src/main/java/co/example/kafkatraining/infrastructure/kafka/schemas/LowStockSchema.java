package co.example.kafkatraining.infrastructure.kafka.schemas;

import lombok.Builder;

@Builder
public record LowStockSchema(String id, String saleId, String customerId, String description) {
}
