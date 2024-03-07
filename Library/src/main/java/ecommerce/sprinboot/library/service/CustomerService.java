package ecommerce.sprinboot.library.service;

import java.util.List;

import ecommerce.sprinboot.library.dto.CustomerDto;
import ecommerce.sprinboot.library.model.Customer;

public interface CustomerService {

    List<Customer> listAll();

    CustomerDto save(CustomerDto customerDto);

    Customer findByUsername(String username);

    Customer saveInfor(Customer customer);

    double calculateDiscount(double amount);
}
