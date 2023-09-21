package Kuehne.Nagle.OMSA.business.order.dto;

import Kuehne.Nagle.OMSA.domain.entities.OrderLine;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link OrderLine}
 */
@Value
@Data
public class OrderLineDto implements Serializable {
    @NotNull
    Integer productQuantity;
    Integer productId;
    String productName;

}