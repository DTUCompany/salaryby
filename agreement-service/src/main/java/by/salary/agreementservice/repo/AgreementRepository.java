package by.salary.agreementservice.repo;

import by.salary.agreementservice.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgreementRepository extends JpaRepository<Agreement, Long> {
}
