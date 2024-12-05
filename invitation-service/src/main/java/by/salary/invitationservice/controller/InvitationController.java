package by.salary.invitationservice.controller;

import by.salary.invitationservice.exceptions.InvitationNotFoundException;
import by.salary.invitationservice.model.InvitationRequestDTO;
import by.salary.invitationservice.model.InvitationResponseDTO;
import by.salary.invitationservice.service.InvitationService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/invitations")
@RequiredArgsConstructor
public class InvitationController {

    private final InvitationService invitationService;

    @GetMapping
    @Operation(summary = "Get all invitation codes")
    @ResponseStatus(HttpStatus.OK)
    public List<InvitationResponseDTO> getInvitationCode() {
        return invitationService.getInvitationCode();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get invitation code by id")
    @ResponseStatus(HttpStatus.OK)
    public InvitationResponseDTO getInvitationCodeById(Long id) throws InvitationNotFoundException {
        return invitationService.getInvitationCodeById(id);
    }

    @PostMapping
    @Operation(summary = "Create invitation code")
    @ResponseStatus(HttpStatus.CREATED)
    public InvitationResponseDTO createInvitationCode(@RequestBody InvitationRequestDTO invitationRequestDTO) {
        return invitationService.createInvitationCode(invitationRequestDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete invitation code by id")
    @ResponseStatus(HttpStatus.OK)
    public InvitationResponseDTO deleteInvitationCodeById(@PathVariable Long id) throws InvitationNotFoundException {
        return invitationService.deleteInvitationCodeById(id);
    }
}
