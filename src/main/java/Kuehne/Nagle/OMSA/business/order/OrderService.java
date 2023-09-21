package Kuehne.Nagle.OMSA.business.order;

import Kuehne.Nagle.OMSA.business.order.dto.OrderDto;
import Kuehne.Nagle.OMSA.business.order.dto.OrderLineDto;
import Kuehne.Nagle.OMSA.domain.CustomerRepository;
import Kuehne.Nagle.OMSA.domain.OrderRepository;
import Kuehne.Nagle.OMSA.domain.entities.Customer;
import Kuehne.Nagle.OMSA.domain.entities.Order;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
@Data
@Service
public class OrderService {

    @Resource
    private OrderRepository orderRepository;
    @Resource
    private CustomerRepository customerRepository;

    public void addNewOrder(OrderDto orderDto) {
        Integer customerId = orderDto.getCustomerId();
        Customer customer = customerRepository.findById(customerId).get();
        Order newOrder = new Order();
        newOrder.setCustomer(customer);
        orderRepository.save(newOrder);
//        List<OrderLineDto> orderLines = orderDto.getOrderLines();

    }
}
