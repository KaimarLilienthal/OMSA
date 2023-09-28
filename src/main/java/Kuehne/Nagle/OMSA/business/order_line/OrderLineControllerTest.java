package Kuehne.Nagle.OMSA.business.order_line;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
public class OrderLineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testChangeProductQuantity() throws Exception {
        // Define test data
        Integer orderLineId = 1;
        Integer newQuantity = 10;

        // Perform the HTTP request
        mockMvc.perform(MockMvcRequestBuilders
                        .patch("/change-quantity")
                        .param("orderLineId", orderLineId.toString())
                        .param("newQuantity", newQuantity.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
