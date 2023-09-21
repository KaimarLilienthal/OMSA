package Kuehne.Nagle.OMSA.business.product;

import Kuehne.Nagle.OMSA.business.product.dto.ProductDto;
import Kuehne.Nagle.OMSA.domain.ProductMapper;
import Kuehne.Nagle.OMSA.domain.ProductRepository;
import Kuehne.Nagle.OMSA.domain.entities.Product;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductRepository productRepository;
    public void addNewProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        productRepository.save(product);
    }
}
