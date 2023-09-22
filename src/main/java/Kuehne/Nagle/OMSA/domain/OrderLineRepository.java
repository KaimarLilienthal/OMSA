package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.domain.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {
    @Query("select o from OrderLine o where o.product.id = ?1")
    List<OrderLine> findByProduct_Id(Integer id);
    @Query("select o from OrderLine o where o.order.id = ?1")
    List<OrderLine> findByOrderId(Integer id);
}