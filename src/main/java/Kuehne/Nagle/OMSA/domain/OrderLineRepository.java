package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.domain.entities.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * The OrderLineRepository interface provides database access methods for the OrderLine entity.
 */
public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

    /**
     * Retrieves a list of order lines by the product ID.
     *
     * @param id The product ID to search for.
     * @return A list of order lines associated with the specified product ID.
     */
    @Query("select o from OrderLine o where o.product.id = ?1")
    List<OrderLine> findByProduct_Id(Integer id);

    /**
     * Retrieves a list of order lines by the order ID.
     *
     * @param id The order ID to search for.
     * @return A list of order lines associated with the specified order ID.
     */
    @Query("select o from OrderLine o where o.order.id = ?1")
    List<OrderLine> findByOrderId(Integer id);
}