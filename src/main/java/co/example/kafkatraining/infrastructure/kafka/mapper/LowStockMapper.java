package co.example.kafkatraining.infrastructure.kafka.mapper;

import co.example.kafkatraining.domain.model.LowStock;
import co.example.kafkatraining.infrastructure.kafka.schemas.LowStockSchema;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface LowStockMapper {
    LowStock to(LowStockSchema lowStockSchema);
    LowStockSchema to(LowStock lowStock);
}
