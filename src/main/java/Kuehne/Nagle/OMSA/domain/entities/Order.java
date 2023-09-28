package Kuehne.Nagle.OMSA.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * The Order entity represents an order in the system.
 */
@Getter
@Setter
@Entity
@Table(name = "\"order\"")
public class Order {

    /**
     * The unique identifier of the order.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * The date when the order was placed.
     */
    @NotNull
    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    /**
     * The customer who placed the order.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}