package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.business.order_line.dto.OrderLineDto;
import Kuehne.Nagle.OMSA.business.order_line.dto.OrderLineExtendedDto;
import Kuehne.Nagle.OMSA.domain.entities.OrderLine;
import org.mapstruct.*;

import java.util.List;

/**
 * The OrderLineMapper interface is responsible for mapping between OrderLine and its DTO objects.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderLineMapper {

    /**
     * Maps an OrderLineDto object to an OrderLine entity.
     *
     * @param orderLineDto The OrderLineDto to be mapped.
     * @return The corresponding OrderLine entity.
     */
    OrderLine toEntity(OrderLineDto orderLineDto);

    /**
     * Maps an OrderLine entity to an OrderLineDto object.
     *
     * @param orderLine The OrderLine entity to be mapped.
     * @return The corresponding OrderLineDto.
     */
    OrderLineDto toDto(OrderLine orderLine);

    /**
     * Maps an OrderLineExtendedDto object to an OrderLine entity.
     *
     * @param orderLineExtendedDto The OrderLineExtendedDto to be mapped.
     * @return The corresponding OrderLine entity.
     */
    @Mapping(source = "productProductName", target = "product.productName")
    @Mapping(source = "productId", target = "product.id")
    @Mapping(source = "orderOrderDate", target = "order.orderDate")
    @Mapping(source = "orderId", target = "order.id")
    OrderLine toEntity(OrderLineExtendedDto orderLineExtendedDto);

    /**
     * Maps an OrderLine entity to an OrderLineExtendedDto object.
     *
     * @param orderLine The OrderLine entity to be mapped.
     * @return The corresponding OrderLineExtendedDto.
     */
    @InheritInverseConfiguration(name = "toEntity")
    OrderLineExtendedDto toDto1(OrderLine orderLine);

    /**
     * Maps a list of OrderLine entities to a list of OrderLineExtendedDto objects.
     *
     * @param orderLines The list of OrderLine entities to be mapped.
     * @return The corresponding list of OrderLineExtendedDto objects.
     */
    List<OrderLineExtendedDto> toDto1(List<OrderLine> orderLines);

}