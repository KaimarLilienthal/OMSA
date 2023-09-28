package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.business.order.dto.OrderByDateDto;
import Kuehne.Nagle.OMSA.business.order.dto.OrderDto;
import Kuehne.Nagle.OMSA.business.order.dto.OrdersDto;
import Kuehne.Nagle.OMSA.domain.entities.Order;
import org.mapstruct.*;

import java.util.List;

/**
 * The OrderMapper interface is responsible for mapping between Order and its DTO objects.
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

    /**
     * Maps an OrderDto object to an Order entity.
     *
     * @param orderDto The OrderDto to be mapped.
     * @return The corresponding Order entity.
     */
    @Mapping(source = "customerId", target = "customer.id")
    Order toEntity(OrderDto orderDto);

    /**
     * Maps an Order entity to an OrderDto object.
     *
     * @param order The Order entity to be mapped.
     * @return The corresponding OrderDto.
     */
    @Mapping(source = "customer.id", target = "customerId")
    OrderDto toDto(Order order);

    /**
     * Partially updates an Order entity based on the provided OrderDto.
     *
     * @param orderDto The OrderDto containing update information.
     * @param order    The Order entity to be updated.
     * @return The updated Order entity.
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "customerId", target = "customer.id")
    Order partialUpdate(OrderDto orderDto, @MappingTarget Order order);

    /**
     * Maps an OrderByDateDto object to an Order entity for date-based operations.
     *
     * @param orderByDateDto The OrderByDateDto to be mapped.
     * @return The corresponding Order entity.
     */
    @Mapping(source = "customerCustomerFullName", target = "customer.customerFullName")
    Order toByDateEntity(OrderByDateDto orderByDateDto);

    /**
     * Maps an Order entity to an OrderByDateDto object for date-based operations.
     *
     * @param order The Order entity to be mapped.
     * @return The corresponding OrderByDateDto.
     */
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "customer.customerFullName", target = "customerCustomerFullName")
    OrderByDateDto toByDateDto(Order order);

    /**
     * Maps a list of Order entities to a list of OrderByDateDto objects for date-based operations.
     *
     * @param orders The list of Order entities to be mapped.
     * @return The corresponding list of OrderByDateDto objects.
     */
    List<OrderByDateDto> toByDateDto(List<Order> orders);

    /**
     * Maps an Order entity to an OrdersDto object.
     *
     * @param order The Order entity to be mapped.
     * @return The corresponding OrdersDto.
     */
    @Mapping(source = "customer.id", target = "customerId")
    OrdersDto toDtos(Order order);

    /**
     * Maps a list of Order entities to a list of OrdersDto objects.
     *
     * @param orders The list of Order entities to be mapped.
     * @return The corresponding list of OrdersDto objects.
     */
    List<OrdersDto> toDtos(List<Order> orders);

    /**
     * Partially updates an Order entity for date-based operations.
     *
     * @param orderByDateDto The OrderByDateDto containing update information.
     * @param order          The Order entity to be updated.
     * @return The updated Order entity.
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "customerCustomerFullName", target = "customer.customerFullName")
    Order partialByDateUpdate(OrderByDateDto orderByDateDto, @MappingTarget Order order);
}