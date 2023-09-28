package Kuehne.Nagle.OMSA.domain;

import Kuehne.Nagle.OMSA.domain.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The ProductRepository interface provides database access methods for the Product entity.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}