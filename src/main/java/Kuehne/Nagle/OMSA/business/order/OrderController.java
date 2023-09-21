package Kuehne.Nagle.OMSA.business.order;

import Kuehne.Nagle.OMSA.business.order.dto.OrderDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
