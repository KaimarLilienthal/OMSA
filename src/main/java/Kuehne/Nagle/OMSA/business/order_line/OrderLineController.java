package Kuehne.Nagle.OMSA.business.order_line;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The OrderLineController class is responsible for handling HTTP requests related to order line management.
 */
@RestController
public class OrderLineController {

    @Resource
    private OrderLineService orderLineService;

    /**
     * Changes the quantity of a product in an order line.
     *
     * @param orderLineId The identifier of the order line to update.
     * @param newQuantity The new quantity to set for the product in the order line.
     */
    @PatchMapping("/change-quantity")
    @Operation(summary = "Change Quantity of a Product in an Order Line ",
            description = "This endpoint allows you to change the quantity of a product in an order line. " +
                    "You need to specify the `orderLineId` to identify the order line you want to update, " +
                    "and provide the `newQuantity` to set the new quantity of the product in the order line. " +
                    "A successful request will update the quantity.")
    public void changeProductQuantity(@RequestParam Integer orderLineId, Integer newQuantity) {
        orderLineService.newProductQuantity(orderLineId, newQuantity);
    }
}
