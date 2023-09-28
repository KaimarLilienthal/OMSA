package Kuehne.Nagle.OMSA.business.customer;

import Kuehne.Nagle.OMSA.business.customer.dto.CustomerDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The CustomerController class is responsible for handling HTTP requests related to customer management.
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    /**
     * Adds a new customer based on the provided customer details.
     *
     * @param customerDto The CustomerDto containing customer information.
     */
    @PostMapping("/new")
    @Operation(summary = "Add a New Customer",
            description = "This endpoint allows you to add a new customer by providing customer details in the request body. " +
                    "The `CustomerDto` should contain information such as customer registration code, full name, e-mail and phone number. " +
                    "A successful request will create a new customer record.")
    public void addNewCustomer(@RequestBody CustomerDto customerDto) {
        customerService.addNewCustomer(customerDto);
    }

}
