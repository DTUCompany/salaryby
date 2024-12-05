package by.salary.agreementservice.controller;

import by.salary.agreementservice.exceptions.AgreementNotFoundException;
import by.salary.agreementservice.model.AgreementStateRequestDTO;
import by.salary.agreementservice.model.AgreementStateResponseDTO;
import by.salary.agreementservice.service.AgreementStateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Agreement state controller", description = "Agreement state management system")
@RestController
@RequestMapping("/agreement-states")
@RequiredArgsConstructor
public class AgreementStateController {

    private final AgreementStateService agreementStateService;

    @Operation(summary = "View a list of available agreement states")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AgreementStateResponseDTO> getAllAgreementStates() {
        return agreementStateService.getAllAgreementStates();
    }

    @Operation(summary = "Get an agreement state by Id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AgreementStateResponseDTO> getAgreementStatesListByAgreementListId(@PathVariable Long id) throws  AgreementNotFoundException{
        return agreementStateService.getAgreementStatesByAgreementListId(id);
    }

    @Operation(summary = "Get an agreement state by Id")
    @GetMapping("/state/{agreementStateId}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementStateResponseDTO getAgreementStateById(@PathVariable Long agreementStateId) throws  AgreementNotFoundException{
        return agreementStateService.getAgreementStateById(agreementStateId);
    }

    @Operation(summary = "Add a new agreement state")
    @PostMapping("/{agreementListId}")
    @ResponseStatus(HttpStatus.CREATED)
    public AgreementStateResponseDTO createAgreementStateInAgreementList(@PathVariable Long agreementListId, @RequestBody AgreementStateRequestDTO agreementStateRequestDTO) {
        return agreementStateService.createAgreementStateInAgreementList(agreementListId, agreementStateRequestDTO);
    }

    @Operation(summary = "Update an agreement state")
    @PatchMapping("/{agreementStateId}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementStateResponseDTO updateAgreementState(@PathVariable Long agreementStateId, @RequestBody AgreementStateResponseDTO agreementStateResponseDTO) throws AgreementNotFoundException {
        return agreementStateService.updateAgreementState(agreementStateId, agreementStateResponseDTO);
    }

    @Operation(summary = "Delete an agreement state")
    @DeleteMapping("/{agreementStateId}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementStateResponseDTO deleteAgreementState(@PathVariable Long agreementStateId) throws AgreementNotFoundException {
        return agreementStateService.deleteAgreementState(agreementStateId);
    }


}
