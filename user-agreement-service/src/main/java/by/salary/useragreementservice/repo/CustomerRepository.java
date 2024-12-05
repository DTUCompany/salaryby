package by.salary.useragreementservice.repo;

import by.salary.useragreementservice.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
