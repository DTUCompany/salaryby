package by.salary.agreementservice.controller;

import by.salary.agreementservice.service.AgreementListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agreementLists")
public class AgreementListController {

    private final AgreementListService agreementListService;

    @Autowired
    public AgreementListController(AgreementListService agreementListService) {
        this.agreementListService = agreementListService;
    }
}
