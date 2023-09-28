package Kuehne.Nagle.OMSA.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * The OrderLine entity represents a line item in an order.
 */
@Getter
@Setter
@Entity
@Table(name = "order_line")
public class OrderLine {

    /**
     * The unique identifier of the order line.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * The quantity of the product in the order line.
     */
    @NotNull
    @Column(name = "product_quantity", nullable = false)
    private Integer productQuantity;

    /**
     * The order to which this order line belongs.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    /**
     * The product associated with this order line.
     */
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}