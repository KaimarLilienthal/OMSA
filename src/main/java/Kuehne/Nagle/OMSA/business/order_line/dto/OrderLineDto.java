package Kuehne.Nagle.OMSA.business.order_line.dto;

import Kuehne.Nagle.OMSA.domain.entities.OrderLine;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link OrderLine}
 */
@Data
@AllArgsConstructor
public class OrderLineDto implements Serializable {
    @NotNull
    Integer id;
    Integer productQuantity;
    Integer productId;
    String productName;

}