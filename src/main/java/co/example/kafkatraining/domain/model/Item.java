package co.example.kafkatraining.domain.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item {
    private String id;
    private String name;
    private String sku;
    private double price;
    private int quantity;

    public void decreaseQuantity(int quantity) throws Exception {

        this.quantity -= quantity;

        if (this.quantity < 0) {
            throw new Exception("insufficient stock");
        }
    }

    public void incrementQuantity(int quantity) {
        this.quantity += quantity;
    }
}
