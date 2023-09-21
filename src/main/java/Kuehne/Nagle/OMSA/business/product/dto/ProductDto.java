package Kuehne.Nagle.OMSA.business.product.dto;

import Kuehne.Nagle.OMSA.domain.entities.Product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Product}
 */
@Value
@Data
public class ProductDto implements Serializable {
    @NotNull
    @Size(max = 255)
    String productName;
    @NotNull
    @Size(max = 8)
    String skuCode;
    @NotNull
    Integer unitPrice;
}