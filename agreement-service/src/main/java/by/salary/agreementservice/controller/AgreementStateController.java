package by.salary.agreementservice.controller;

import by.salary.agreementservice.service.AgreementStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agreementStates")
public class AgreementStateController {

    private final AgreementStateService agreementStateService;

    @Autowired
    public AgreementStateController(AgreementStateService agreementStateService) {
        this.agreementStateService = agreementStateService;
    }
}
