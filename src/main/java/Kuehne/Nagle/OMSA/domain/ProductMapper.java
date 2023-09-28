package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.business.product.dto.ProductDto;
import Kuehne.Nagle.OMSA.domain.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * The ProductMapper interface is responsible for mapping between Product and ProductDto objects.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    /**
     * Maps a ProductDto object to a Product entity.
     *
     * @param productDto The ProductDto to be mapped.
     * @return The corresponding Product entity.
     */
    Product toEntity(ProductDto productDto);

}