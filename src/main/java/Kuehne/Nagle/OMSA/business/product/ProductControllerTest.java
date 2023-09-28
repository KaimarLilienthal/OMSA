package Kuehne.Nagle.OMSA.business.product;

import Kuehne.Nagle.OMSA.business.product.dto.ProductDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddNewProduct() throws Exception {
        ProductDto productDto = new ProductDto(); // Create a product DTO with test data
        productDto.setProductName("Banana"); // Set customer ID
        productDto.setSkuCode("12345678"); // Set SKU code 8digits
        productDto.setUnitPrice(500); // Set product price

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/product/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(productDto)))
                .andExpect(status().isOk());
    }
}
