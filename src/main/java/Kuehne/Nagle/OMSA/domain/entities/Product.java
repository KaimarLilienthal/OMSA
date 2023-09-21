package Kuehne.Nagle.OMSA.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "product_name", nullable = false)
    private String productName;

    @Size(max = 8)
    @NotNull
    @Column(name = "sku_code", nullable = false, length = 8)
    private String skuCode;

    @NotNull
    @Column(name = "unit_price", nullable = false)
    private Integer unitPrice;

}