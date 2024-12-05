package by.salary.useragreementservice.service;

import by.salary.useragreementservice.entity.Customer;
import by.salary.useragreementservice.entity.Payment;
import by.salary.useragreementservice.exceptions.CustomerNotFoundException;
import by.salary.useragreementservice.exceptions.PaymentNotFoundException;
import by.salary.useragreementservice.model.PaymentRequestDTO;
import by.salary.useragreementservice.model.PaymentResponseDTO;
import by.salary.useragreementservice.repo.CustomerRepository;
import by.salary.useragreementservice.repo.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final CustomerRepository customerRepository;

    public List<PaymentResponseDTO> getAllPayments() {
        return paymentRepository.findAll().stream().map(PaymentResponseDTO::new).toList();
    }

    public PaymentResponseDTO getPaymentById(Long id) {
        return paymentRepository.findById(id)
                .map(PaymentResponseDTO::new)
                .orElseThrow(() -> new PaymentNotFoundException("Payment with id: " + id + " not found", HttpStatus.NOT_FOUND));
    }

    public PaymentResponseDTO createPayment(PaymentRequestDTO paymentRequestDTO) {
        Customer customer = customerRepository.findById(paymentRequestDTO.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id " + paymentRequestDTO.getCustomerId() + " not found", HttpStatus.NOT_FOUND));
        String name = paymentRequestDTO.getName();
        String description = paymentRequestDTO.getDescription();
        Customer moderator = customerRepository.findById(paymentRequestDTO.getModeratorId())
                .orElseThrow(() -> new CustomerNotFoundException("Moderator with id " + paymentRequestDTO.getModeratorId() + " not found", HttpStatus.NOT_FOUND));
        String moderatorComment = paymentRequestDTO.getModeratorComment();
        Double price = paymentRequestDTO.getPrice();
        Date paymentDate = new Date(System.currentTimeMillis());
        Payment payment = Payment.builder()
                .customer(customer)
                .name(name)
                .description(description)
                .moderator(moderator)
                .moderatorComment(moderatorComment)
                .price(price)
                .date(paymentDate).build();

        paymentRepository.save(payment);
        return new PaymentResponseDTO(payment);
    }

    public PaymentResponseDTO deletePaymentById(Long id) {
        Optional<Payment> payment = paymentRepository.findById(id);
        if (payment.isEmpty()) {
            throw new PaymentNotFoundException("Payment with id " + id + " not found", HttpStatus.NOT_FOUND);
        }
        paymentRepository.deleteById(id);
        return new PaymentResponseDTO(payment.get());
    }
}
