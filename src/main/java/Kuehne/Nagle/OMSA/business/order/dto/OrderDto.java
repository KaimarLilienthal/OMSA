package Kuehne.Nagle.OMSA.business.order.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Order}
 */
@Data
@Value
public class OrderDto implements Serializable {
    @NotNull
    Integer customerId;
    List<OrderLineDto> orderLines;
}