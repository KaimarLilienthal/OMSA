package Kuehne.Nagle.OMSA.business.customer;

import Kuehne.Nagle.OMSA.business.customer.dto.CustomerDto;
import Kuehne.Nagle.OMSA.domain.CustomerMapper;
import Kuehne.Nagle.OMSA.domain.CustomerRepository;
import Kuehne.Nagle.OMSA.domain.entities.Customer;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Resource
    public CustomerMapper customerMapper;
    @Resource
    public CustomerRepository customerRepository;

    public void addNewCustomer(CustomerDto customerDto) {
        Customer customer = customerMapper.toEntity(customerDto);
        customerRepository.save(customer);
    }
}
