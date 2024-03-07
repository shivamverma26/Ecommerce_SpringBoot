package ecommerce.sprinboot.library.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.sprinboot.library.dto.CustomerDto;
import ecommerce.sprinboot.library.model.Customer;
import ecommerce.sprinboot.library.repository.CustomerRepository;
import ecommerce.sprinboot.library.repository.RoleRepository;
import ecommerce.sprinboot.library.service.CustomerService;

import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private RoleRepository repository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> listAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public CustomerDto save(CustomerDto customerDto) {

        Customer customer = new Customer();
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setUsername(customerDto.getUsername());
        customer.setPassword(customerDto.getPassword());
        customer.setRoles(Arrays.asList(repository.findByName("CUSTOMER")));

        Customer customerSave = customerRepository.save(customer);
        return mapperDTO(customerSave);
    }

    @Override
    public Customer findByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    @Override
    public Customer saveInfor(Customer customer) {
        Customer customer1 = customerRepository.findByUsername(customer.getUsername());
        customer1.setFirstName(customer.getFirstName());
        customer1.setLastName(customer.getLastName());
        customer1.setAddress(customer.getAddress());
        customer1.setCity(customer.getCity());
        customer1.setCountry(customer.getCountry());
        customer1.setPhoneNumber(customer.getPhoneNumber());
        return customerRepository.save(customer1);
    }

    @Override
    public double calculateDiscount(double amount) {
        double discountAmount;
        if (amount >= 1000 && amount < 2000)
            discountAmount = (amount * 5.0) / 100;
        else if (amount >= 2000 && amount < 3000) {
            discountAmount = (amount * 8.0) / 100;
        } else if(amount >= 3000) {
            discountAmount = (amount * 15.0) / 100;
        } else {
            discountAmount = 0;
        }

        return discountAmount;

    }

    private CustomerDto mapperDTO(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setPassword(customer.getPassword());
        customerDto.setUsername(customer.getUsername());
        return customerDto;
    }
}
