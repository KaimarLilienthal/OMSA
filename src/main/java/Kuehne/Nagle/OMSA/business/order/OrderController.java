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
    @Operation(summary = "Add a New Order",
            description = "This endpoint is used to create a new order. " +
                    "The request body should contain an `OrderDto` object with the required information-" +
                    " including the customer, order date, and order lines.")
    private void addNewOrder(@RequestBody OrderDto orderDto) {
        orderservice.addNewOrder(orderDto);
    }

    @GetMapping("/order-by-date")
    @Operation(summary = "Get Orders by Date",
            description = "This endpoint retrieves a list of orders based on the specified order date. " +
                    "The `orderDate` parameter should be provided in the request to filter orders.")
    private List<OrderByDateDto> getOrdersByDate(@RequestParam LocalDate orderDate) {
        return orderservice.getOrdersByDate(orderDate);
    }

    @GetMapping("/find-by-product")
    @Operation(summary = "Get Orders by Product Id",
            description = "This endpoint retrieves a list of orders that contain the specified product ID. " +
                    "The `productId` parameter should be provided in the request to filter orders.")
    private List<OrdersDto> getOrdersByProduct(@RequestParam Integer productId) {
        return orderservice.getOrdersByProduct(productId);
    }

    @GetMapping("/find-by-customer")
    @Operation(summary = "Get Orders by Customer Id",
            description = "This endpoint retrieves a list of orders associated with the specified customer ID. " +
                    "The `customerId` parameter should be provided in the request to filter orders.")
    private List<OrdersDto> getOrdersByCustomer(@RequestParam Integer customerId) {
        return orderservice.getOrdersByCustomer(customerId);
    }

}
