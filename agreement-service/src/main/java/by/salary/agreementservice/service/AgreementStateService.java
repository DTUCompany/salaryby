package by.salary.agreementservice.service;

import by.salary.agreementservice.repo.AgreementStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgreementStateService {

    private final AgreementStateRepository agreementStateRepository;

    @Autowired
    public AgreementStateService(AgreementStateRepository agreementStateRepository) {
        this.agreementStateRepository = agreementStateRepository;
    }
}
