package Kuehne.Nagle.OMSA.business.order_line;

import Kuehne.Nagle.OMSA.domain.OrderLineRepository;
import Kuehne.Nagle.OMSA.domain.entities.OrderLine;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * The OrderLineService class provides business logic for managing order line-related operations.
 */
@Service
public class OrderLineService {

    @Resource
    private OrderLineRepository orderLineRepository;

    /**
     * Changes the quantity of a product in an order line.
     *
     * @param orderLineId The identifier of the order line to update.
     * @param newQuantity The new quantity to set for the product in the order line.
     */
    public void newProductQuantity(Integer orderLineId, Integer newQuantity) {
        changeProductQuantity(orderLineId, newQuantity);
    }

    private void changeProductQuantity(Integer orderLineId, Integer newQuantity) {
        OrderLine orderLine = orderLineRepository.findById(orderLineId).get();
        orderLine.setProductQuantity(newQuantity);
        orderLineRepository.save(orderLine);
    }
}
