package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.domain.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The CustomerRepository interface provides database access methods for the Customer entity.
 */
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}