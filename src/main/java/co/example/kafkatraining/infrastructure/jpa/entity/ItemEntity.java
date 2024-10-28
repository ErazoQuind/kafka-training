package co.example.kafkatraining.infrastructure.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ItemEntity {
    @Id
    private String itemId;
    private int quantity;
}
