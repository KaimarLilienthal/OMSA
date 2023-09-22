package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.business.order.dto.OrderLineDto;
import Kuehne.Nagle.OMSA.domain.entities.OrderLine;
import Kuehne.Nagle.OMSA.business.order.dto.OrderLineExtendedDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderLineMapper {
    OrderLine toEntity(OrderLineDto orderLineDto);


    OrderLineDto toDto(OrderLine orderLine);

    List<OrderLineDto> toDto(List<OrderLine> orderLines);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderLine partialUpdate(OrderLineDto orderLineDto, @MappingTarget OrderLine orderLine);

    @Mapping(source = "productProductName", target = "product.productName")
    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "orderOrderDate", target = "order.orderDate")
    @Mapping(source = "orderId", target = "order.id")
    OrderLine toEntity(OrderLineExtendedDto orderLineExtendedDto);

    @InheritInverseConfiguration(name = "toEntity")
    OrderLineExtendedDto toDto1(OrderLine orderLine);
    List<OrderLineExtendedDto> toDto1(List<OrderLine> orderLines);
    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    OrderLine partialUpdate(OrderLineExtendedDto orderLineExtendedDto, @MappingTarget OrderLine orderLine);
}