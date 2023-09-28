package Kuehne.Nagle.OMSA.business.customer;

import Kuehne.Nagle.OMSA.business.customer.dto.CustomerDto;
import Kuehne.Nagle.OMSA.domain.CustomerMapper;
import Kuehne.Nagle.OMSA.domain.CustomerRepository;
import Kuehne.Nagle.OMSA.domain.entities.Customer;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
/**
 * The CustomerService class provides business logic for managing customer-related operations.
 */
@Service
public class CustomerService {
    @Resource
    public CustomerMapper customerMapper;
    @Resource
    public CustomerRepository customerRepository;

    /**
     * Adds a new customer based on the provided customer DTO.
     *
     * @param customerDto The CustomerDto containing customer information.
     */
    public void addNewCustomer(CustomerDto customerDto) {
        createNewCustomer(customerDto);
    }

    /**
     * Creates a new customer entity based on the provided customer DTO and saves it to the repository.
     *
     * @param customerDto The CustomerDto containing customer information.
     */
    private void createNewCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        customerRepository.save(customer);
    }
}
