package Kuehne.Nagle.OMSA.business.customer.dto;

import Kuehne.Nagle.OMSA.domain.entities.Customer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link Customer}
 */

@Data
public class CustomerDto implements Serializable {
    @NotNull
    Integer registrationCode;
    @NotNull
    @Size(max = 255)
    String customerFullName;
    @NotNull
    @Size(max = 255)
    String email;
    @NotNull
    @Size(max = 20)
    String phoneNumber;


}