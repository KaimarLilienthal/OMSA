package Kuehne.Nagle.OMSA.business.order.dto;

import Kuehne.Nagle.OMSA.domain.entities.OrderLine;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link OrderLine}
 */
@Data
public class OrderLineExtendedDto implements Serializable {
    Integer id;
    @NotNull
    Integer productQuantity;
    Integer orderId;
    LocalDate orderOrderDate;
    Integer productId;
    String productProductName;
}