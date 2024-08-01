package by.salary.agreementservice.controller;

import by.salary.agreementservice.exceptions.AgreementNotFoundException;
import by.salary.agreementservice.model.AgreementStateRequestDTO;
import by.salary.agreementservice.model.AgreementStateResponseDTO;
import by.salary.agreementservice.service.AgreementStateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Agreement state controller", description = "Agreement state management system")
@RestController
@RequestMapping("/agreementstates")
public class AgreementStateController {

    private final AgreementStateService agreementStateService;

    @Autowired
    public AgreementStateController(AgreementStateService agreementStateService) {
        this.agreementStateService = agreementStateService;
    }


    @Operation(summary = "View a list of available agreement states")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to reach is not found")
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AgreementStateResponseDTO> getAllAgreementStates() {
        return agreementStateService.getAllAgreementStates();
    }

    @Operation(summary = "Get an agreement state by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved agreement"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<AgreementStateResponseDTO> getAgreementStateByAgreementListId(@PathVariable Long id) throws  AgreementNotFoundException{
        return agreementStateService.getAgreementStatesByAgreementListId(id);
    }

    @Operation(summary = "Get an agreement state by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved agreement"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to reach is not found")
    })
    @GetMapping("/state/{agreementStateId}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementStateResponseDTO getAgreementStateById(@PathVariable Long agreementStateId) throws  AgreementNotFoundException{
        return agreementStateService.getAgreementStateById(agreementStateId);
    }

    @Operation(summary = "Add a new agreement state")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created agreement"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to reach is not found")
    })
    @PostMapping("/{agreementListId}")
    @ResponseStatus(HttpStatus.CREATED)
    public AgreementStateResponseDTO createAgreementStateInAgreementList(@PathVariable Long agreementListId, @RequestBody AgreementStateRequestDTO agreementStateRequestDTO) {
        return agreementStateService.createAgreementStateInAgreementList(agreementListId, agreementStateRequestDTO);
    }

    @Operation(summary = "Update an agreement state")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated agreement"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to reach is not found")
    })
    @PatchMapping("/{agreementStateId}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementStateResponseDTO updateAgreementState(@PathVariable Long agreementStateId, @RequestBody AgreementStateResponseDTO agreementStateResponseDTO) throws AgreementNotFoundException {
        return agreementStateService.updateAgreementState(agreementStateId, agreementStateResponseDTO);
    }

    @Operation(summary = "Delete an agreement state")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted agreement"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to reach is not found")
    })
    @DeleteMapping("/{agreementStateId}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementStateResponseDTO deleteAgreementState(@PathVariable Long agreementStateId) throws AgreementNotFoundException {
        return agreementStateService.deleteAgreementState(agreementStateId);
    }


}
