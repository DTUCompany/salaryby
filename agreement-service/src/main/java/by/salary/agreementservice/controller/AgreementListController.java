package by.salary.agreementservice.controller;

import by.salary.agreementservice.exceptions.AgreementNotFoundException;
import by.salary.agreementservice.model.AgreementListRequestDTO;
import by.salary.agreementservice.model.AgreementListResponseDTO;
import by.salary.agreementservice.service.AgreementListService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agreement-lists")
@RequiredArgsConstructor
public class AgreementListController {

    private final AgreementListService agreementListService;

    @Operation(summary = "View a list of available agreement lists")
    @ResponseStatus(HttpStatus.OK)
    public List<AgreementListResponseDTO> getAllAgreementLists() {
        return agreementListService.getAllAgreementLists();
    }

    @Operation(summary = "Get an agreement list by Id")
    @GetMapping("/{agreementId}")
    @ResponseStatus(HttpStatus.OK)
    public List<AgreementListResponseDTO> getAgreementListsByAgreementId(@PathVariable Long agreementId) throws AgreementNotFoundException {
        return agreementListService.getAgreementListsByAgreementId(agreementId);
    }

    @Operation(summary = "Get an agreement list by Id")
    @GetMapping("/list/{agreementListId}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementListResponseDTO getAgreementListById(@PathVariable Long agreementListId) throws AgreementNotFoundException {
        return agreementListService.getAgreementListById(agreementListId);
    }

    @Operation(summary = "Add a new agreement list")
    @PostMapping("/{agreementId}")
    @ResponseStatus(HttpStatus.CREATED)
    public AgreementListResponseDTO createAgreementList(@PathVariable Long agreementId, @RequestBody AgreementListRequestDTO agreementListRequestDTO) {
        return agreementListService.createAgreementList(agreementId, agreementListRequestDTO);
    }

    @Operation(summary = "Update an agreement list")
    @PatchMapping("/{agreementListId}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementListResponseDTO updateAgreementList(@PathVariable Long agreementListId, @RequestBody AgreementListRequestDTO agreementListRequestDTO) throws AgreementNotFoundException {
        return agreementListService.updateAgreementList(agreementListId, agreementListRequestDTO);
    }

    @Operation(summary = "Delete an agreement list")
    @DeleteMapping("/{agreementListId}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementListResponseDTO deleteAgreementList(@PathVariable Long agreementListId) throws AgreementNotFoundException {
        return agreementListService.deleteAgreementList(agreementListId);
    }
}
