package Kuehne.Nagle.OMSA.business.order.dto;

import Kuehne.Nagle.OMSA.domain.entities.Order;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

/**
 * DTO for {@link Order}
 */
@Data
@Value
public class OrderDto implements Serializable {
    @NotNull
    Integer customerId;
    @NotNull
    Instant orderDate;
    List<OrderLineDto> orderLines;
}