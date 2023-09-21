package Kuehne.Nagle.OMSA.business.customer;

import Kuehne.Nagle.OMSA.business.customer.dto.CustomerDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Resource
    private CustomerService customerService;


    @PostMapping("/new")
    @Operation(summary = "Kuvab id-le vastava ürituse",
            description = "Tagastab nimekirja üritusest koos infoga: id, eventName, eventDate, eventPlace, eventInfo ja status")
    public void addNewCustomer(@RequestBody CustomerDto customerDto) {
        customerService.addNewCustomer(customerDto);
    }

}
