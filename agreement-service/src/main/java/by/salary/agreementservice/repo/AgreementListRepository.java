package by.salary.agreementservice.repo;

import by.salary.agreementservice.entity.AgreementList;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AgreementListRepository extends JpaRepository<AgreementList, Long> {

    List<AgreementList> findByAgreementId(Long agreementId);
}
