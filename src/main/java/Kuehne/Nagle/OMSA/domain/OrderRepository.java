package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

/**
 * The OrderRepository interface provides database access methods for the Order entity.
 */
public interface OrderRepository extends JpaRepository<Order, Integer> {

    /**
     * Retrieves a list of orders by the customer ID.
     *
     * @param id The customer ID to search for.
     * @return A list of orders associated with the specified customer ID.
     */
    @Query("select o from Order o where o.customer.id = ?1")
    List<Order> findByCustomerId(Integer id);

    /**
     * Retrieves a list of orders by the order date.
     *
     * @param orderDate The order date to search for.
     * @return A list of orders with the specified order date.
     */
    @Query("select o from Order o where o.orderDate = ?1")
    List<Order> findByOrderDate(LocalDate orderDate);
}