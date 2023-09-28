package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.business.order_line.dto.OrderLineDto;
import Kuehne.Nagle.OMSA.business.order_line.dto.OrderLineExtendedDto;
import Kuehne.Nagle.OMSA.domain.entities.OrderLine;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderLineMapper {
    OrderLine toEntity(OrderLineDto orderLineDto);

    OrderLineDto toDto(OrderLine orderLine);

    @Mapping(source = "productProductName", target = "product.productName")
    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "orderOrderDate", target = "order.orderDate")
    @Mapping(source = "orderId", target = "order.id")
    OrderLine toEntity(OrderLineExtendedDto orderLineExtendedDto);

    @InheritInverseConfiguration(name = "toEntity")
    OrderLineExtendedDto toDto1(OrderLine orderLine);

    List<OrderLineExtendedDto> toDto1(List<OrderLine> orderLines);

}