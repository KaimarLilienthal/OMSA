package Kuehne.Nagle.OMSA.business.customer;

import com.fasterxml.jackson.databind.ObjectMapper;
import Kuehne.Nagle.OMSA.business.customer.dto.CustomerDto;
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
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void testAddNewCustomer() throws Exception {
        CustomerDto customerDto = new CustomerDto(); // Create a customer DTO with test data
        customerDto.setRegistrationCode(12345); // Set customer registration code
        customerDto.setCustomerFullName("John Doe"); // Set customer full name
        customerDto.setEmail("john.doe@example.com"); // Set customer email
        customerDto.setPhoneNumber("1234567890"); // Set customer phone number

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/customer/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(customerDto)))
                .andExpect(status().isOk());
    }
}
