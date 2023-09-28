package Kuehne.Nagle.OMSA.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * The Product entity represents a product in the system.
 */
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    /**
     * The unique identifier of the product.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * The name of the product.
     */
    @Size(max = 255)
    @NotNull
    @Column(name = "product_name", nullable = false)
    private String productName;

    /**
     * The SKU (Stock Keeping Unit) code of the product.
     */
    @Size(max = 8)
    @NotNull
    @Column(name = "sku_code", nullable = false, length = 8)
    private String skuCode;

    /**
     * The unit price of the product.
     */
    @NotNull
    @Column(name = "unit_price", nullable = false)
    private Integer unitPrice;

}