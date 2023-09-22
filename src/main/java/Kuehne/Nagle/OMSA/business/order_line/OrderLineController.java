package Kuehne.Nagle.OMSA.business.order_line;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderLineController {

    @Resource
    private OrderLineService orderLineService;

    @PatchMapping("/change-quantity")
    @Operation(summary = "Lisab uue Tellimuse",
            description = "")
    public void changeProductQuantity(@RequestParam Integer orderLineId, Integer newQuantity) {
        orderLineService.newProductQuantity(orderLineId, newQuantity);
    }
}
