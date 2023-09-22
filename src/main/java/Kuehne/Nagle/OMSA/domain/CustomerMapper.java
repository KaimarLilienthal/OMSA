package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.business.customer.dto.CustomerDto;
import Kuehne.Nagle.OMSA.domain.entities.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {
    Customer toEntity(CustomerDto customerDto);

}