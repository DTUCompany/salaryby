package by.salary.agreementservice.controller;

import by.salary.agreementservice.exceptions.AgreementNotFoundException;
import by.salary.agreementservice.model.AgreementRequestDTO;
import by.salary.agreementservice.model.AgreementResponseDTO;
import by.salary.agreementservice.service.AgreementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Agreement controller", description = "Agreement management system")
@RestController
@RequestMapping("/agreements")
@RequiredArgsConstructor
public class AgreementController {

    private final AgreementService agreementService;

    @Operation(summary = "View a list of available agreements")
    @GetMapping
    public List<AgreementResponseDTO> getAllAgreements() {
        return agreementService.getAllAgreements();
    }

    @Operation(summary = "Get an agreement by Id")
    @GetMapping("/{id}")
    public AgreementResponseDTO getAgreementById(@PathVariable Long id) throws AgreementNotFoundException {
        return agreementService.getAgreementById(id);
    }

    @Operation(summary = "Add a new agreement")
    @PostMapping
    public AgreementResponseDTO createAgreement(@RequestBody AgreementRequestDTO agreementRequestDTO) {
        return agreementService.createAgreement(agreementRequestDTO);
    }

    @Operation(summary = "Update an agreement")
    @PatchMapping("/{id}")
    public AgreementResponseDTO updateAgreement(@PathVariable Long id, @RequestBody AgreementRequestDTO agreementResponseDTO) throws AgreementNotFoundException {
        return agreementService.updateAgreement(id, agreementResponseDTO);
    }

    @Operation(summary = "Delete an agreement by Id")
    @DeleteMapping("/{id}")
    public AgreementResponseDTO deleteAgreement(@PathVariable Long id) throws AgreementNotFoundException {
        return agreementService.deleteAgreement(id);
    }


}
