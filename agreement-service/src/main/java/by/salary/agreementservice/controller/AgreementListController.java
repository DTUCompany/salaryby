package by.salary.agreementservice.controller;

import by.salary.agreementservice.exceptions.AgreementNotFoundException;
import by.salary.agreementservice.model.AgreementListRequestDTO;
import by.salary.agreementservice.model.AgreementListResponseDTO;
import by.salary.agreementservice.service.AgreementListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agreementlists")
@RequiredArgsConstructor
public class AgreementListController {

    private final AgreementListService agreementListService;

    @Operation(summary = "View a list of available agreement lists")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved list")
    })
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<AgreementListResponseDTO> getAllAgreementLists() throws AgreementNotFoundException {
        return agreementListService.getAllAgreementLists();
    }

    @Operation(summary = "Get an agreement list by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved agreement list"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to reach is not found")
    })
    @GetMapping("/{agreementId}")
    @ResponseStatus(HttpStatus.OK)
    public List<AgreementListResponseDTO> getAgreementListsByAgreementId(@PathVariable Long agreementId) throws AgreementNotFoundException {
        return agreementListService.getAgreementListsByAgreementId(agreementId);
    }

    @Operation(summary = "Get an agreement list by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved agreement list"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to reach is not found")
    })
    @GetMapping("/list/{agreementListId}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementListResponseDTO getAgreementListById(@PathVariable Long agreementListId) throws AgreementNotFoundException {
        return agreementListService.getAgreementListById(agreementListId);
    }

    @Operation(summary = "Add a new agreement list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successfully created agreement list"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to reach is not found")
    })
    @PostMapping("/{agreementId}")
    @ResponseStatus(HttpStatus.CREATED)
    public AgreementListResponseDTO createAgreementList(@PathVariable Long agreementId, @RequestBody AgreementListRequestDTO agreementListRequestDTO) {
        return agreementListService.createAgreementList(agreementId, agreementListRequestDTO);
    }

    @Operation(summary = "Update an agreement list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated agreement list"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to reach is not found")
    })
    @PatchMapping("/{agreementListId}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementListResponseDTO updateAgreementList(@PathVariable Long agreementListId, @RequestBody AgreementListRequestDTO agreementListRequestDTO) throws AgreementNotFoundException {
        return agreementListService.updateAgreementList(agreementListId, agreementListRequestDTO);
    }

    @Operation(summary = "Delete an agreement list")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully deleted agreement list"),
            @ApiResponse(responseCode = "404", description = "The agreement you were trying to reach is not found")
    })
    @DeleteMapping("/{agreementListId}")
    @ResponseStatus(HttpStatus.OK)
    public AgreementListResponseDTO deleteAgreementList(@PathVariable Long agreementListId) throws AgreementNotFoundException {
        return agreementListService.deleteAgreementList(agreementListId);
    }
}
