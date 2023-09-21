package Kuehne.Nagle.OMSA.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query("select o from Order o where o.orderDate = ?1")
    List<Order> findByOrderDate(LocalDate orderDate);
}