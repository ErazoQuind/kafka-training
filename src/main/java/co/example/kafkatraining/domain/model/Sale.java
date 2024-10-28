package co.example.kafkatraining.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    private String saleId;
    private String customerId;
    private double amount;
    private LocalDate saleDate;
    private List<Item> items;
}
