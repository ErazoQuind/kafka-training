package co.example.kafkatraining.domain.model;

import co.example.kafkatraining.domain.enums.RefundStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Refund {
    private Long refundId;
    private Long orderId;
    private double amount;
    private String reason;
    private RefundStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
