package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.business.product.dto.ProductDto;
import Kuehne.Nagle.OMSA.domain.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {
    Product toEntity(ProductDto productDto);

}