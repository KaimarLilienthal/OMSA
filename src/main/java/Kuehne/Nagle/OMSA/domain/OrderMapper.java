package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.business.order.dto.OrderDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    @Mapping(source = "customerId", target = "customer.id")
    Order toEntity(OrderDto orderDto);

    @Mapping(source = "customer.id", target = "customerId")
    OrderDto toDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "customerId", target = "customer.id")
    Order partialUpdate(OrderDto orderDto, @MappingTarget Order order);
}