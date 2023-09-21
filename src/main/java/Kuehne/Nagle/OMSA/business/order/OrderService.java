package Kuehne.Nagle.OMSA.business.order;

import Kuehne.Nagle.OMSA.business.order.dto.OrderDto;
import Kuehne.Nagle.OMSA.business.order.dto.OrderLineDto;
import Kuehne.Nagle.OMSA.domain.CustomerRepository;
import Kuehne.Nagle.OMSA.domain.OrderLineRepository;
import Kuehne.Nagle.OMSA.domain.OrderRepository;
import Kuehne.Nagle.OMSA.domain.ProductRepository;
import Kuehne.Nagle.OMSA.domain.entities.Customer;
import Kuehne.Nagle.OMSA.domain.entities.Order;
import Kuehne.Nagle.OMSA.domain.entities.OrderLine;
import Kuehne.Nagle.OMSA.domain.entities.Product;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.Instant;
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

    public void addNewOrder(OrderDto orderDto) {
        Integer customerId = orderDto.getCustomerId();
        Customer customer = customerRepository.findById(customerId).get();
        Order newOrder = new Order();
        newOrder.setCustomer(customer);
        newOrder.setOrderDate(Instant.now());
        orderRepository.save(newOrder);

        List<OrderLineDto> orderLines = orderDto.getOrderLines();
        for (OrderLineDto orderLineDto :orderLines) {
            Integer productId = orderLineDto.getProductId();
            Product product = productRepository.findById(productId).get();
            OrderLine newOrderLine = new OrderLine();
            newOrderLine.setProduct(product);
            Integer productQuantity = orderLineDto.getProductQuantity();
            newOrderLine.setProductQuantity(productQuantity);
            newOrderLine.setOrder(newOrder);
            orderLineRepository.save(newOrderLine);
        }
    }
}
