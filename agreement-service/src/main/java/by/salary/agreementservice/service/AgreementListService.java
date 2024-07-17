package by.salary.agreementservice.service;

import by.salary.agreementservice.repo.AgreementListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgreementListService {

    private final AgreementListRepository agreementListRepository;

    @Autowired
    public AgreementListService(AgreementListRepository agreementListRepository) {
        this.agreementListRepository = agreementListRepository;
    }
}
