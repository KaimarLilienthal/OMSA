package Kuehne.Nagle.OMSA.business.order;

import Kuehne.Nagle.OMSA.business.order.dto.OrderByDateDto;
import Kuehne.Nagle.OMSA.business.order.dto.OrderDto;
import Kuehne.Nagle.OMSA.business.order.dto.OrdersDto;
import Kuehne.Nagle.OMSA.business.order_line.dto.OrderLineDto;
import Kuehne.Nagle.OMSA.business.order_line.dto.OrderLineExtendedDto;
import Kuehne.Nagle.OMSA.domain.*;
import Kuehne.Nagle.OMSA.domain.entities.Customer;
import Kuehne.Nagle.OMSA.domain.entities.Order;
import Kuehne.Nagle.OMSA.domain.entities.OrderLine;
import Kuehne.Nagle.OMSA.domain.entities.Product;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * The OrderService class provides business logic for managing order-related operations.
 */
@Data
@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;
    @Resource
    private CustomerRepository customerRepository;
    @Resource
    private ProductRepository productRepository;
    @Resource
    private OrderLineRepository orderLineRepository;
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private OrderLineMapper orderLineMapper;

    /**
     * Adds a new order based on the provided order DTO.
     *
     * @param orderDto The OrderDto containing order information.
     */
    @Transactional
    public void addNewOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        Integer customerId = orderDto.getCustomerId();
        Customer customer = customerRepository.findById(customerId).get();
        order.setCustomer(customer);
        orderRepository.save(order);
        createOrderLines(orderDto, order);
    }

    /**
     * Retrieves a list of orders based on the specified order date.
     *
     * @param orderDate The date used to filter orders.
     * @return A list of OrderByDateDto objects representing orders on the specified date.
     */
    @Transactional
    public List<OrderByDateDto> getOrdersByDate(LocalDate orderDate) {
        List<Order> orders = orderRepository.findByOrderDate(orderDate);
        List<OrderByDateDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderByDateDto orderByDateDto = orderMapper.toByDateDto(order);
            List<OrderLine> orderLines = orderLineRepository.findByOrderId(order.getId());
            List<OrderLineExtendedDto> orderLineDtos = getOrderLineExtendedDtos(orderLines);
            orderByDateDto.setOrderLines(orderLineDtos);
            orderDtos.add(orderByDateDto);
        }
        return orderDtos;
    }

    /**
     * Retrieves a list of orders that contain the specified product ID.
     *
     * @param productId The product ID used to filter orders.
     * @return A list of OrdersDto objects representing orders containing the specified product.
     */
    public List<OrdersDto> getOrdersByProduct(Integer productId) {
        List<OrderLine> orderLines = orderLineRepository.findByProduct_Id(productId);
        HashSet<Integer> orderIds = getUniqueOrderIds(orderLines);
        ArrayList<Integer> uniqueOrderIds = new ArrayList<>(orderIds);
        List<Order> orders = orderRepository.findAllById(uniqueOrderIds);
        return orderMapper.toDtos(orders);

    }

    /**
     * Retrieves a list of orders associated with the specified customer ID.
     *
     * @param customerId The customer ID used to filter orders.
     * @return A list of OrdersDto objects representing orders associated with the specified customer.
     */
    public List<OrdersDto> getOrdersByCustomer(Integer customerId) {
        List<Order> orders = orderRepository.findByCustomerId(customerId);
        return orderMapper.toDtos(orders);
    }

    private List<OrderLineExtendedDto> getOrderLineExtendedDtos(List<OrderLine> orderLines) {
        List<OrderLineExtendedDto> orderLineDtos = orderLineMapper.toDto1(orderLines); // Assuming you have a mapper for OrderLine to OrderLineDto
        for (OrderLineExtendedDto orderlineDto : orderLineDtos) {
            Integer productId = orderlineDto.getProductId();
            Product product = productRepository.findById(productId).get();
            orderlineDto.setProductId(product.getId());
            orderlineDto.setProductProductName(product.getProductName());
        }
        return orderLineDtos;
    }

    private void createOrderLines(OrderDto orderDto, Order order) {
        List<OrderLineDto> orderLines = orderDto.getOrderLines();
        for (OrderLineDto orderLineDto : orderLines) {
            Integer productId = orderLineDto.getProductId();
            Product product = productRepository.findById(productId).get();
            OrderLine newOrderLine = new OrderLine();
            newOrderLine.setProduct(product);
            Integer productQuantity = orderLineDto.getProductQuantity();
            newOrderLine.setProductQuantity(productQuantity);
            newOrderLine.setOrder(order);
            orderLineRepository.save(newOrderLine);
        }
    }

    private static HashSet<Integer> getUniqueOrderIds(List<OrderLine> orderLines) {
        HashSet<Integer> orderIds = new HashSet<>();
        for (OrderLine orderLine : orderLines) {
            orderIds.add(orderLine.getOrder().getId());
        }
        return orderIds;
    }
}


