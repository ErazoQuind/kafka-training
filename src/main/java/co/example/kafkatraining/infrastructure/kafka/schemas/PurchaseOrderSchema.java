package co.example.kafkatraining.infrastructure.kafka.schemas;

import lombok.Builder;

@Builder
public record PurchaseOrderSchema(String id, String saleId, String customerId, String description) {
}
