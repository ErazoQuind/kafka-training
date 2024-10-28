package co.example.kafkatraining.infrastructure.jpa.repository;

import co.example.kafkatraining.infrastructure.jpa.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemJpaRepository extends JpaRepository<ItemEntity, String> {
}
