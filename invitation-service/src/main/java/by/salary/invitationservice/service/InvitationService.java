package by.salary.invitationservice.service;

import by.salary.invitationservice.entity.Invitation;
import by.salary.invitationservice.exceptions.InvitationNotFoundException;
import by.salary.invitationservice.model.InvitationRequestDTO;
import by.salary.invitationservice.model.InvitationResponseDTO;
import by.salary.invitationservice.repo.InvitationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvitationService {

    private final InvitationRepository invitationRepository;


    public List<InvitationResponseDTO> getInvitationCode() {
        return invitationRepository.findAll()
                .stream()
                .map(invitation -> new InvitationResponseDTO(invitation.getId(), invitation.getInvitationCode()))
                .toList();
    }

    public InvitationResponseDTO getInvitationCodeById(Long id) {
        return invitationRepository.findById(id)
                .map(InvitationResponseDTO::new)
                .orElseThrow(() -> new InvitationNotFoundException("Invitation with id: " + id + " not found", HttpStatus.NOT_FOUND));
    }

    public InvitationResponseDTO createInvitationCode(InvitationRequestDTO invitationRequestDTO) {
        Invitation invitation = invitationRepository.save(new Invitation(invitationRequestDTO.getId(), invitationRequestDTO.getInvitationCode()));
        return new InvitationResponseDTO(invitation.getId(), invitation.getInvitationCode());
    }

    public InvitationResponseDTO deleteInvitationCodeById(Long id) {
        Optional<Invitation> invitation = invitationRepository.findById(id);
        if(invitation.isEmpty()){
            throw new InvitationNotFoundException("Invitation not found", HttpStatus.NOT_FOUND);
        }
        invitationRepository.delete(invitation.get());
        return new InvitationResponseDTO(invitation.get().getId(), invitation.get().getInvitationCode());
    }
}
