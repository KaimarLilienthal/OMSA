package Kuehne.Nagle.OMSA.business.order;

import Kuehne.Nagle.OMSA.business.order.dto.OrderDto;
import Kuehne.Nagle.OMSA.business.order.dto.OrderLineDto;
import Kuehne.Nagle.OMSA.domain.*;
import Kuehne.Nagle.OMSA.domain.entities.Customer;
import Kuehne.Nagle.OMSA.domain.entities.OrderLine;
import Kuehne.Nagle.OMSA.domain.entities.Product;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
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

    public void addNewOrder(OrderDto orderDto) {
        Order order = orderMapper.toEntity(orderDto);
        Integer customerId = orderDto.getCustomerId();
        Customer customer = customerRepository.findById(customerId).get();
        order.setCustomer(customer);
        orderRepository.save(order);

        List<OrderLineDto> orderLines = orderDto.getOrderLines();
        for (OrderLineDto orderLineDto :orderLines) {
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

    public List<Order> getOrdersByDate(LocalDate orderDate) {
        return orderRepository.findByOrderDate(orderDate);

    }
}
