package co.example.kafkatraining.infrastructure.jpa.adapter;

import co.example.kafkatraining.domain.model.Item;
import co.example.kafkatraining.domain.port.ItemRepository;
import co.example.kafkatraining.infrastructure.jpa.mapper.ItemMapper;
import co.example.kafkatraining.infrastructure.jpa.repository.ItemJpaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemRepository {
    private final ItemJpaRepository itemJpaRepository;
    private final ItemMapper mapper;

    @Override
    public Item save(Item item) {
        return mapper.to(itemJpaRepository.save(mapper.to(item)));
    }

    @Override
    public Optional<Item> findById(String itemId) {
        return itemJpaRepository.findById(itemId).map(mapper::to);
    }
}
