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
    @Operation(summary = "Kuvab listi kasutaja stuudiotest",
            description = "Tagastab info koos studioId ja studioName'ga ning imageId'ga jne.MUUDA ÕIGEKS!!!")
    public void addNewProduct(ProductDto productDto) {
        productService.addNewProduct(productDto);
    }
}
