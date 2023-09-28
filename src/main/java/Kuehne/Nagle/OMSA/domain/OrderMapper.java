package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.business.order.dto.OrderByDateDto;
import Kuehne.Nagle.OMSA.business.order.dto.OrderDto;
import Kuehne.Nagle.OMSA.business.order.dto.OrdersDto;
import Kuehne.Nagle.OMSA.domain.entities.Order;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {
    @Mapping(source = "customerId", target = "customer.id")
    Order toEntity(OrderDto orderDto);

    @Mapping(source = "customer.id", target = "customerId")
    OrderDto toDto(Order order);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "customerId", target = "customer.id")
    Order partialUpdate(OrderDto orderDto, @MappingTarget Order order);

    @Mapping(source = "customerCustomerFullName", target = "customer.customerFullName")
    Order toByDateEntity(OrderByDateDto orderByDateDto);

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "customer.customerFullName", target = "customerCustomerFullName")
    OrderByDateDto toByDateDto(Order order);

    List<OrderByDateDto> toByDateDto(List<Order> orders);

    @Mapping(source = "customer.id", target = "customerId")
    OrdersDto toDtos(Order order);

    List<OrdersDto> toDtos(List<Order> orders);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "customerCustomerFullName", target = "customer.customerFullName")
    Order partialByDateUpdate(OrderByDateDto orderByDateDto, @MappingTarget Order order);
}