package by.salary.useragreementservice.service;

import by.salary.useragreementservice.dao.User;
import by.salary.useragreementservice.entity.Customer;
import by.salary.useragreementservice.exceptions.CustomerNotFoundException;
import by.salary.useragreementservice.exceptions.UserNotFoundException;
import by.salary.useragreementservice.model.CustomerRequestDTO;
import by.salary.useragreementservice.model.CustomerResponseDTO;
import by.salary.useragreementservice.repo.CustomerRepository;
import by.salary.useragreementservice.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    public List<CustomerResponseDTO> getAllCustomers() {
        return customerRepository.findAll().stream().map(CustomerResponseDTO::new).toList();
    }

    public CustomerResponseDTO getCustomerById(Long id) {
        return customerRepository.findById(id)
                .map(CustomerResponseDTO::new)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id: " + id + " not found", HttpStatus.NOT_FOUND));
    }

    public CustomerResponseDTO createCustomer(CustomerRequestDTO customerRequestDTO) {
        Customer customer = new Customer();
        Optional<User> user = userRepository.findById(customerRequestDTO.getUserId());
        if (user.isEmpty()) {
            throw new UserNotFoundException("User with id " + customerRequestDTO.getUserId() + " not found", HttpStatus.NOT_FOUND);
        }
        customer.setUser(user.get());
        customerRepository.save(customer);
        return new CustomerResponseDTO(customer);
    }

    public CustomerResponseDTO deleteCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isEmpty()) {
            throw new CustomerNotFoundException("Customer with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        customerRepository.deleteById(id);
        return new CustomerResponseDTO(customer.get());
    }
}
