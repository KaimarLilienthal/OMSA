package Kuehne.Nagle.OMSA.business.order.dto;

import Kuehne.Nagle.OMSA.domain.entities.Order;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Order}
 */
@Data
public class OrdersDto implements Serializable {
    Integer id;
    LocalDate orderDate;
    Integer customerId;
}