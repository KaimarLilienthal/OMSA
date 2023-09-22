package Kuehne.Nagle.OMSA.business.order;

import Kuehne.Nagle.OMSA.business.order.dto.OrderByDateDto;
import Kuehne.Nagle.OMSA.business.order.dto.OrderDto;
import Kuehne.Nagle.OMSA.business.order.dto.OrdersDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderService orderservice;

    @PostMapping("/new")
    @Operation(summary = "Lisab uue Tellimuse",
            description = "")
    private void addNewOrder(@RequestBody OrderDto orderDto) {
        orderservice.addNewOrder(orderDto);
    }

    @GetMapping("/order-by-date")
    @Operation(summary = "Lisab uue Tellimuse",
            description = "")
    private List<OrderByDateDto> getOrdersByDate(@RequestParam LocalDate orderDate) {
        return orderservice.getOrdersByDate(orderDate);
    }
    @GetMapping("/find-by-product")
    @Operation(summary = "Lisab uue Tellimuse",
            description = "")
    private List<OrdersDto> getOrdersByProduct(@RequestParam Integer productId) {
        return orderservice.getOrdersByProduct(productId);
    }

    @GetMapping("/find-by-customer")
    @Operation(summary = "Lisab uue Tellimuse",
            description = "")
    private List<OrdersDto> getOrdersByCustomer(@RequestParam Integer customerId) {
        return orderservice.getOrdersByCustomer(customerId);
    }

}
