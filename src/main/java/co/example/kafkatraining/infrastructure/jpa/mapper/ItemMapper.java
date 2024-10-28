package co.example.kafkatraining.infrastructure.jpa.mapper;

import co.example.kafkatraining.domain.model.Item;
import co.example.kafkatraining.infrastructure.jpa.entity.ItemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ItemMapper {
    @Mapping(source = "itemId", target = "id")
    Item to(ItemEntity itemEntity);
    @Mapping(source = "id", target = "itemId")
    ItemEntity to(Item item);
}
