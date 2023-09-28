package Kuehne.Nagle.OMSA.business.order.dto;

import Kuehne.Nagle.OMSA.business.order_line.dto.OrderLineExtendedDto;
import Kuehne.Nagle.OMSA.domain.entities.Order;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link Order}
 */
@Data
public class OrderByDateDto implements Serializable {
    Integer id;
    @NotNull
    Integer customerId;
    @NotNull
    LocalDate orderDate;
    String customerCustomerFullName;
    List<OrderLineExtendedDto> orderLines;
}