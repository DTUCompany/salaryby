package by.salary.organisationservice.controller;

import by.salary.organisationservice.exceptions.OrganisationNotFoundException;
import by.salary.organisationservice.model.OrganisationRequestDTO;
import by.salary.organisationservice.model.OrganisationResponseDTO;
import by.salary.organisationservice.service.OrganisationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class OrganisationController {

    private static OrganisationService organisationService;

    @Autowired
    public OrganisationController(OrganisationService organisationService) {
        OrganisationController.organisationService = organisationService;
    }

    @Operation(summary = "Get all organisations")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrganisationResponseDTO> getAllOrganisations() {
        return organisationService.getAllOrganisations();
    }

    @Operation(summary = "Get organisation by id")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrganisationResponseDTO getOrganisationById(Long id) throws OrganisationNotFoundException {
        return organisationService.getOrganisationById(id);
    }

    @Operation(summary = "Create organisation")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrganisationResponseDTO createOrganisation(@RequestBody OrganisationRequestDTO organisationRequestBody) {
        return organisationService.createOrganisation(organisationRequestBody);
    }

    @Operation(summary = "Delete organisation by id")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrganisationResponseDTO deleteOrganisationById(@PathVariable Long id) throws OrganisationNotFoundException {
        return organisationService.deleteOrganisationById(id);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update organisation")
    @ResponseStatus(HttpStatus.OK)
    public OrganisationResponseDTO updateOrganisation(@PathVariable Long id, @RequestBody OrganisationRequestDTO organisationRequestBody) throws OrganisationNotFoundException {
        return organisationService.updateOrganisation(id, organisationRequestBody);
    }
}
