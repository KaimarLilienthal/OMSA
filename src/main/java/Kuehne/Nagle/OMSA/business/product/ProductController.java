package Kuehne.Nagle.OMSA.business.product;

import Kuehne.Nagle.OMSA.business.product.dto.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @PostMapping("/new")
    @Operation(summary = "Add a New Product",
            description = "This endpoint allows you to add a new product by providing product details in the request body. " +
                    "The `ProductDto` should contain information such as product product name, sku code and unit price. " +
                    "A successful request will create a new customer record.")
    public void addNewProduct(ProductDto productDto) {
        productService.addNewProduct(productDto);
    }
}
