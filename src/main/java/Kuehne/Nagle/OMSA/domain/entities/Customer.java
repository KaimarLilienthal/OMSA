package Kuehne.Nagle.OMSA.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * The Customer entity represents a customer in the system.
 */
@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {

    /**
     * The unique identifier of the customer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    /**
     * The registration code of the customer.
     */
    @NotNull
    @Column(name = "registration_code", nullable = false)
    private Integer registrationCode;

    /**
     * The full name of the customer.
     */
    @Size(max = 255)
    @NotNull
    @Column(name = "customer_full_name", nullable = false)
    private String customerFullName;

    /**
     * The email address of the customer.
     */
    @Size(max = 255)
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * The phone number of the customer.
     */
    @Size(max = 20)
    @NotNull
    @Column(name = "phone_number", nullable = false, length = 20)
    private String phoneNumber;

}