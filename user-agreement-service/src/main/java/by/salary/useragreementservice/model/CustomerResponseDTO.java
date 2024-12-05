package by.salary.useragreementservice.model;

import by.salary.useragreementservice.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerResponseDTO {

    private Long id;

    private Long userId;

    private List<PaymentResponseDTO> payments;

    public CustomerResponseDTO(Customer customer) {
        this.id = customer.getId();
        this.userId = customer.getUser().getId();
        this.payments = customer.getPayments().stream().map(PaymentResponseDTO::new).toList();
    }
}
