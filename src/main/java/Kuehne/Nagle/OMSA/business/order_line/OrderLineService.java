package Kuehne.Nagle.OMSA.business.order_line;

import Kuehne.Nagle.OMSA.domain.OrderLineRepository;
import Kuehne.Nagle.OMSA.domain.entities.OrderLine;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OrderLineService {

    @Resource
    private OrderLineRepository orderLineRepository;
    public void newProductQuantity(Integer orderLineId, Integer newQuantity) {
        changeProductQuantity(orderLineId, newQuantity);
    }

    private void changeProductQuantity(Integer orderLineId, Integer newQuantity) {
        OrderLine orderLine = orderLineRepository.findById(orderLineId).get();
        orderLine.setProductQuantity(newQuantity);
        orderLineRepository.save(orderLine);
    }
}
