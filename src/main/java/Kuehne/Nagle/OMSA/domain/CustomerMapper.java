package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.business.customer.dto.CustomerDto;
import Kuehne.Nagle.OMSA.domain.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

/**
 * The CustomerMapper interface is responsible for mapping between Customer and CustomerDto objects.
 */
@Component
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    /**
     * Maps a CustomerDto object to a Customer entity.
     *
     * @param customerDto The CustomerDto to be mapped.
     * @return The corresponding Customer entity.
     */
    Customer toEntity(CustomerDto customerDto);

}