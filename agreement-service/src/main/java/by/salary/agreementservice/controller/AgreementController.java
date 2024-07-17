package by.salary.agreementservice.controller;

import by.salary.agreementservice.exceptions.AgreementNotFoundException;
import by.salary.agreementservice.model.AgreementRequestDTO;
import by.salary.agreementservice.model.AgreementResponseDTO;
import by.salary.agreementservice.service.AgreementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Agreement controller", description = "Agreement management system")
@RestController
@RequestMapping("/agreements")
public class AgreementController {

    private final AgreementService agreementService;

    @Autowired
    public AgreementController(AgreementService agreementService) {
        this.agreementService = agreementService;
    }

    @Operation(summary = "View a list of available agreements")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to reach is not found")
    })
    @GetMapping
    public List<AgreementResponseDTO> getAllAgreements() throws AgreementNotFoundException {
        return agreementService.getAllAgreements();
    }

    @Operation(summary = "Get an agreement by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved agreement"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to reach is not found")
    })
    @GetMapping("/{id}")
    public AgreementResponseDTO getAgreementById(@PathVariable Long id) throws AgreementNotFoundException {
        return agreementService.getAgreementById(id);
    }

    @Operation(summary = "Add a new agreement")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created agreement")
    })
    @PostMapping
    public AgreementResponseDTO createAgreement(@RequestBody AgreementRequestDTO agreementResponseDTO) {
        return agreementService.createAgreement(agreementResponseDTO);
    }

    @Operation(summary = "Update an agreement")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated agreement"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to reach is not found")
    })
    @PatchMapping("/{id}")
    public AgreementResponseDTO updateAgreement(@PathVariable Long id, @RequestBody AgreementRequestDTO agreementResponseDTO) throws AgreementNotFoundException {
        return agreementService.updateAgreement(id, agreementResponseDTO);
    }

    @Operation(summary = "Delete an agreement by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted agreement"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to delete is not found")
    })
    @DeleteMapping("/{id}")
    public AgreementResponseDTO deleteAgreement(@PathVariable Long id) throws AgreementNotFoundException {
        return agreementService.deleteAgreement(id);
    }


}
