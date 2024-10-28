package co.example.kafkatraining.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LowStock {
    private String id;
    private String saleId;
    private String customerId;
    private String description;
}
