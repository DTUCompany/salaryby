package by.salary.agreementservice.repo;

import by.salary.agreementservice.entity.AgreementState;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AgreementStateRepository extends JpaRepository<AgreementState, Long> {

    List<AgreementState> findByAgreementListId(Long id);
}
