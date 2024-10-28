package co.example.kafkatraining.infrastructure.kafka.mapper;

import co.example.kafkatraining.domain.model.InsufficientStock;
import co.example.kafkatraining.infrastructure.kafka.schemas.InsufficientStockSchema;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface InsufficientStockMapper {
    InsufficientStock to(InsufficientStockSchema insufficientStockSchema);
    InsufficientStockSchema to(InsufficientStock insufficientStock);
}
