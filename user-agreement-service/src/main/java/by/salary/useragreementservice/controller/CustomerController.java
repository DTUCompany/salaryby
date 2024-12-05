package by.salary.useragreementservice.controller;

import by.salary.useragreementservice.exceptions.CustomerNotFoundException;
import by.salary.useragreementservice.model.CustomerRequestDTO;
import by.salary.useragreementservice.model.CustomerResponseDTO;
import by.salary.useragreementservice.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @Operation(summary = "Get all customers")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerResponseDTO> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @Operation(summary = "Get customer by id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponseDTO getCustomerById(Long id) throws CustomerNotFoundException {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponseDTO createCustomer(@RequestBody CustomerRequestDTO customerRequestDTO) {
        return customerService.createCustomer(customerRequestDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerResponseDTO deleteCustomerById(Long id) throws CustomerNotFoundException {
        return customerService.deleteCustomerById(id);
    }
}
