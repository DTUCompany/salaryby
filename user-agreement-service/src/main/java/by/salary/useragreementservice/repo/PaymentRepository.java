package by.salary.useragreementservice.repo;

import by.salary.useragreementservice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
