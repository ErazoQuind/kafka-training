package co.example.kafkatraining.domain.port;

import co.example.kafkatraining.domain.model.Item;

import java.util.Optional;

public interface ItemRepository {
    Item save(Item item);
    Optional<Item> findById(String itemId);
}
