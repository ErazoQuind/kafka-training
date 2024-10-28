package co.example.kafkatraining.infrastructure.kafka.schemas;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.List;

public record SaleSchema(String saleId,
                         String customerId,
                         double amount,
                         @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
                         LocalDate saleDate,
                         List<ItemSchema> items) {
}
