package Kuehne.Nagle.OMSA.business.product;

import Kuehne.Nagle.OMSA.business.product.dto.ProductDto;
import Kuehne.Nagle.OMSA.domain.ProductMapper;
import Kuehne.Nagle.OMSA.domain.ProductRepository;
import Kuehne.Nagle.OMSA.domain.entities.Product;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * The ProductService class provides business logic for managing product-related operations.
 */
@Service
public class ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductRepository productRepository;

    /**
     * Adds a new product based on the provided product DTO.
     *
     * @param productDto The ProductDto containing product information.
     */
    public void addNewProduct(ProductDto productDto) {
        createNewProduct(productDto);
    }

    private void createNewProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        productRepository.save(product);
    }

}
