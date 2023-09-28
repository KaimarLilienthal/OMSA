package Kuehne.Nagle.OMSA.business.order;

import Kuehne.Nagle.OMSA.business.order_line.dto.OrderLineDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import Kuehne.Nagle.OMSA.business.order.dto.OrderDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Collections;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddNewOrder() throws Exception {
        OrderDto orderDto = new OrderDto(); // Create an order DTO with test data
        orderDto.setCustomerId(1); // Set customer ID
        orderDto.setOrderDate(LocalDate.now()); // Set todays date
        orderDto.setOrderLines(Collections.singletonList( new OrderLineDto(1,1,1,"Peeter")));// Set all order lines

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/order/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(orderDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetOrdersByDate() throws Exception {
        // Define a sample LocalDate to use as the orderDate parameter
        LocalDate orderDate = LocalDate.of(2023, 9, 28); // Replace with your desired date

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/order/order-by-date")
                        .param("orderDate", orderDate.toString()) // Pass the orderDate parameter
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray()); // Assumes the response is a JSON array
    }

    @Test
    public void testGetOrdersByProduct() throws Exception {
        // Define a sample productId to use as the productId parameter
        Integer productId = 123; // Replace with your desired productId

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/order/find-by-product")
                        .param("productId", productId.toString()) // Pass the productId parameter
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray()); // Assumes the response is a JSON array
    }

    @Test
    public void testGetOrdersByCustomer() throws Exception {
        // Define a sample customerId to use as the customerId parameter
        Integer customerId = 456; // Replace with your desired customerId

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/order/find-by-customer")
                        .param("customerId", customerId.toString()) // Pass the customerId parameter
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray()); // Assumes the response is a JSON array
    }

}
