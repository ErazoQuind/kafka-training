package co.example.kafkatraining.infrastructure.kafka.mapper;

import co.example.kafkatraining.domain.model.Sale;
import co.example.kafkatraining.infrastructure.kafka.schemas.SaleSchema;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface SaleMapper {
    Sale to(SaleSchema saleSchema);
    SaleSchema to(Sale sale);
}
